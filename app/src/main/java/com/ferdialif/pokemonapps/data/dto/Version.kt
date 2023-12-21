package com.ferdialif.pokemonapps.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)