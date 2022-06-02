package com.example.lordoftherings.quote.data

import androidx.lifecycle.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow

class QuoteRepository constructor(
    private val quoteDao: QuoteDao,
    private val quoteApiService: QuoteApiService) {

    fun getQuotes() : LiveData<List<QuoteModel>> = liveData {
        emitSource(quoteDao.getAll().asLiveData())
        val quoteModelList : QuoteModelList = quoteApiService.getQuotes()
        val quotes : List<QuoteModel> = quoteModelList.docs
        quoteDao.insert(quotes)
        emitSource(quoteDao.getAll().asLiveData())
    }

}