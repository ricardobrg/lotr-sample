package com.example.lordoftherings.movie.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieModelList constructor(
   @field:Json var docs : List<MovieModel>,
   @field:Json var total: Int,
   @field:Json var limit: Int,
   @field:Json var offset: Int,
   @field:Json var page: Int,
   @field:Json var pages: Int
)