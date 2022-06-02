package com.example.lordoftherings.character.data

import com.example.lordoftherings.AppNetwork

object CharacterApi {
    val retrofitService : CharacterApiService by lazy {
        AppNetwork.retrofit.create(CharacterApiService::class.java)
    }
}