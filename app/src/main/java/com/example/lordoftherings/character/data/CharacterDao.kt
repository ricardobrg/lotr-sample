package com.example.lordoftherings.character.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterModel>>

    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT DISTINCT characters.* FROM characters " +
            "INNER JOIN quotes ON quotes.character = characters.id " +
            "WHERE quotes.movie = :movieId LIMIT 10 OFFSET 10*:page")
    fun getByMovieId(movieId: String, page: Int? = 0): Flow<List<CharacterModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: List<CharacterModel>)

}