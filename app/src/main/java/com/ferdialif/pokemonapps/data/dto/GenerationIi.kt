package com.ferdialif.pokemonapps.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIi(
    @SerialName("crystal")
    val crystal: Crystal?,
    @SerialName("gold")
    val gold: Gold?,
    @SerialName("silver")
    val silver: Silver?
)