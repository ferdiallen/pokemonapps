package com.ferdialif.pokemonapps.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferdialif.pokemonapps.data.dto.GeneralPokemonModel
import com.ferdialif.pokemonapps.data.dto.toGeneralPokemonData
import com.ferdialif.pokemonapps.data.local.dao.PokedexDao
import com.ferdialif.pokemonapps.domain.model.GeneralModelPokemonData
import com.ferdialif.pokemonapps.domain.use_case.GetPokemonDetailUseCase
import com.ferdialif.pokemonapps.domain.use_case.GetPokemonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel(
    private val pokemonUseCase: GetPokemonUseCase,
    private val pokemonDetailUseCase: GetPokemonDetailUseCase,
    private val dao: PokedexDao
) : ViewModel() {
    private val _pokemonData = MutableStateFlow<List<GeneralModelPokemonData>>(emptyList())
    val pokemonData = _pokemonData.asStateFlow()
    private val _shouldShowSearchBar = MutableStateFlow(false)
    val shouldShowSearchBar = _shouldShowSearchBar.asStateFlow()

    init {
        retrieveData()
    }

    fun searchBarState(data: Boolean) {
        _shouldShowSearchBar.update {
            data
        }
    }

    private fun retrieveApiData() = viewModelScope.launch(Dispatchers.IO) {
        pokemonUseCase.getPokemon { }.mapLatest {
            it?.results
        }.collectLatest {
            it?.forEach { result ->
                pokemonDetailUseCase.getPokemonDetail(result.name, onError = {})
                    .collectLatest { pokemonDetail ->
                        dao.insertDataIntoDatabase(
                            pokemonDetail?.toGeneralPokemonData()
                                ?: return@collectLatest
                        )
                    }
            }
        }
    }

    private fun retrieveData() = viewModelScope.launch(Dispatchers.IO) {
        dao.getListOfPokemonData().collectLatest { result ->
            if (result.isEmpty()) {
                retrieveApiData()
            } else {
                _pokemonData.update {
                    result
                }
            }
        }
    }
}