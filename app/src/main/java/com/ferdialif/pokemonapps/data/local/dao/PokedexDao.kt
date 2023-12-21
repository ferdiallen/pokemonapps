package com.ferdialif.pokemonapps.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ferdialif.pokemonapps.domain.model.GeneralModelPokemonData
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataIntoDatabase(data: GeneralModelPokemonData)

    @Query("SELECT * FROM GeneralModelPokemonData")
    fun getListOfPokemonData(): Flow<List<GeneralModelPokemonData>>

    @Query("DELETE FROM GeneralModelPokemonData where name =:name")
    suspend fun deletePokemonFromDatabase(name:String)
}