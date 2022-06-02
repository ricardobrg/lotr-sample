package com.example.lordoftherings.movie.data

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie")
    suspend fun getMovies() : MovieModelList
}