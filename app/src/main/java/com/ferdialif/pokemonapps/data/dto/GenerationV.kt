package com.ferdialif.pokemonapps.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationV(
    @SerialName("black-white")
    val blackWhite: BlackWhite?
)