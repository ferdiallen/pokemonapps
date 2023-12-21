package com.ferdialif.pokemonapps.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GeneralModelPokemonData(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val image: String
)
