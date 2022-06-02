package com.example.lordoftherings.movie.data

import com.example.lordoftherings.AppNetwork

object MovieApi {
    val retrofitService : MovieApiService by lazy {
        AppNetwork.retrofit.create(MovieApiService::class.java)
    }
}