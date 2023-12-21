package com.ferdialif.pokemonapps.data.api

import com.ferdialif.pokemonapps.data.dto.PokemonModelDetail

interface GetDetailPokemon {
    suspend fun getDetailPokemon(name:String): PokemonModelDetail?
}