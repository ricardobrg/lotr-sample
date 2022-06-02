package com.example.lordoftherings.quote.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "quotes")
@JsonClass(generateAdapter = true)
data class QuoteModel constructor(
    @PrimaryKey
    @field:Json(name="id")
    val id: String,
    @field:Json(name="dialog")
    val dialog: String,
    @field:Json(name="movie")
    val movie: String,
    @field:Json(name="character")
    val character: String,
)