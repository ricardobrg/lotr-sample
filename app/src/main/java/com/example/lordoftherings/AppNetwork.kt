package com.example.lordoftherings

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AppNetwork {
    companion object{
        private const val token: String = "4eXbI01uZSeFe8PQdDFO"
        private const val baseUrl : String =
            "https://the-one-api.dev/v2/";

        private val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader(
                "Authorization", "Bearer $token").build()
            chain.proceed(request)
        }.build()

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)                // Moshi maps JSON to classes
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}