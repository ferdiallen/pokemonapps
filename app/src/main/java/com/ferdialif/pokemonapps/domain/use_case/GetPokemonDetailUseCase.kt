package com.ferdialif.pokemonapps.domain.use_case

import com.ferdialif.pokemonapps.data.api.GetDetailPokemon
import com.ferdialif.pokemonapps.data.dto.PokemonModelDetail
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetPokemonDetailUseCase(
    private val detail: GetDetailPokemon
) {
    fun getPokemonDetail(name:String, onError: (String) -> Unit) = flow {
        val res = try {
            detail.getDetailPokemon(name)
        } catch (e: Exception) {
            println(e.localizedMessage)
            null
        } catch (e: IOException) {
            println(e.localizedMessage)
            null
        }
        emit(res)
    }
}