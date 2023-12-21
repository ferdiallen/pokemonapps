package com.ferdialif.pokemonapps.domain.use_case

import com.ferdialif.pokemonapps.data.api.GetPokemon
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetPokemonUseCase(
    private val pokemon: GetPokemon
) {
    fun getPokemon(onError: (String) -> Unit) = flow {
        val res = try {
            pokemon.getPokemon()
        } catch (e: Exception) {
            onError(e.localizedMessage ?: "")
            null
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "")
            null
        }
        emit(res)
    }
}