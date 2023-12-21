package com.ferdialif.pokemonapps.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName("base_stat")
    val baseStat: Int?,
    @SerialName("effort")
    val effort: Int?,
    @SerialName("stat")
    val stat: StatX?
)