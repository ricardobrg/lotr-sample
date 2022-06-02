package com.example.lordoftherings.character.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lordoftherings.AppDatabase
import com.example.lordoftherings.character.data.CharacterApi
import com.example.lordoftherings.character.data.CharacterApiService
import com.example.lordoftherings.character.data.CharacterDao
import com.example.lordoftherings.character.data.CharacterRepository
import com.example.lordoftherings.quote.data.QuoteApi
import com.example.lordoftherings.quote.data.QuoteApiService
import com.example.lordoftherings.quote.data.QuoteDao
import com.example.lordoftherings.quote.data.QuoteRepository


class CharacterViewModelProvFactory(private val context: Context, val movieId: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val characterDao : CharacterDao = AppDatabase.getInstance(context).characterDao()
        val characterApiService : CharacterApiService = CharacterApi.retrofitService
        val quoteDao: QuoteDao = AppDatabase.getInstance(context).quoteDao()
        val quoteApiService : QuoteApiService = QuoteApi.retrofitService
        val quoteRepository = QuoteRepository(quoteDao, quoteApiService)
        val repository = CharacterRepository(
            characterDao, characterApiService, quoteRepository, movieId
        )
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharacterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
