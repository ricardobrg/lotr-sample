package com.example.lordoftherings.character.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterModelList constructor(
   @field:Json val docs : List<CharacterModel>,
   @field:Json val total: Int,
   @field:Json val limit: Int,
   @field:Json val offset: Int,
   @field:Json val page: Int,
   @field:Json val pages: Int
)