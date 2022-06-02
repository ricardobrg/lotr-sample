package com.example.lordoftherings.character.data

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacters() : CharacterModelList
}