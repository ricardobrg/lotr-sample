package com.example.lordoftherings.movie.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAll(): Flow<List<MovieModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: List<MovieModel>)

    @Update
    fun update(movie: MovieModel)

}