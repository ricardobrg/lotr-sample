package com.example.lordoftherings.quote.data

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface QuoteApiService {
    @GET("quote")
    suspend fun getQuotes() : QuoteModelList
}