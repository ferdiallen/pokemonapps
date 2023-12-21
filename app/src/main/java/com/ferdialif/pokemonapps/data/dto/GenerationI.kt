package com.ferdialif.pokemonapps.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationI(
    @SerialName("red-blue")
    val redBlue: RedBlue?,
    @SerialName("yellow")
    val yellow: Yellow?
)