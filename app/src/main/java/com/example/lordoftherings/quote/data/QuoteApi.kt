package com.example.lordoftherings.quote.data

import com.example.lordoftherings.AppNetwork

object QuoteApi {
    val retrofitService : QuoteApiService by lazy {
        AppNetwork.retrofit.create(QuoteApiService::class.java)
    }
}