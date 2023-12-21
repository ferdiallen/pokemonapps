package com.ferdialif.pokemonapps.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeneralPokemonModel(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonResult> = emptyList()
)

@Serializable
data class PokemonResult(
    val name: String = "",
    val url: String = ""
)