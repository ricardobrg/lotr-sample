package com.example.lordoftherings.quote.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quotes")
    fun getAll(): Flow<List<QuoteModel>>

    @Query("SELECT * FROM quotes WHERE character = :characterId")
    fun getByCharacter(characterId: Int): Flow<List<QuoteModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(quote: List<QuoteModel>)

    @Query("DELETE FROM quotes")
    suspend fun delete();

}