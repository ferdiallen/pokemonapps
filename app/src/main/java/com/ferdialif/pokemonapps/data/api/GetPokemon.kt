package com.ferdialif.pokemonapps.data.api

import com.ferdialif.pokemonapps.data.dto.GeneralPokemonModel

interface GetPokemon {
    suspend fun getPokemon(): GeneralPokemonModel?
}