package com.example.lordoftherings.character.data

import androidx.lifecycle.*
import com.example.lordoftherings.quote.data.QuoteApiService
import com.example.lordoftherings.quote.data.QuoteRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow

class CharacterRepository constructor(
    private val characterDao: CharacterDao,
    private val characterApiService: CharacterApiService,
    private val quoteRepository: QuoteRepository,
    private val movieId: String,
    private var page: Int? = 0) {

    fun getCharacters() : LiveData<List<CharacterModel>> = liveData {
        emitSource(characterDao.getByMovieId(movieId, page).asLiveData())
        val characterModelList : CharacterModelList = characterApiService.getCharacters()
        val characters : List<CharacterModel> = characterModelList.docs
        characterDao.insert(characters)
        quoteRepository.getQuotes()
        emitSource(characterDao.getByMovieId(movieId, page).asLiveData())
    }

}