package com.ferdialif.pokemonapps.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ferdialif.pokemonapps.data.local.dao.PokedexDao
import com.ferdialif.pokemonapps.domain.model.GeneralModelPokemonData

@Database(entities = [GeneralModelPokemonData::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun dao(): PokedexDao
}