package com.ferdialif.pokemonapps.presentation.detail

import androidx.lifecycle.ViewModel
import com.ferdialif.pokemonapps.data.dto.PokemonModelDetail
import com.ferdialif.pokemonapps.domain.use_case.GetPokemonDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val detailUseCase: GetPokemonDetailUseCase
) : ViewModel() {
    private val _detailPokemon = MutableStateFlow<PokemonModelDetail?>(null)
    val pokemonDetailModel = _detailPokemon.asStateFlow()
}