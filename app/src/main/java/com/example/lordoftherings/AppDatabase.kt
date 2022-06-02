package com.example.lordoftherings

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lordoftherings.character.data.CharacterDao
import com.example.lordoftherings.character.data.CharacterModel
import com.example.lordoftherings.movie.data.MovieDao
import com.example.lordoftherings.movie.data.MovieModel
import com.example.lordoftherings.quote.data.QuoteDao
import com.example.lordoftherings.quote.data.QuoteModel

@Database(entities= [MovieModel::class, CharacterModel::class, QuoteModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun characterDao(): CharacterDao
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}