package com.example.lordoftherings.movie.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "movies")
@JsonClass(generateAdapter = true)
data class MovieModel constructor(
    @PrimaryKey
    @field:Json(name = "_id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "runtimeInMinutes")
    val runtimeInMinutes: Int,
    @field:Json(name = "budgetInMillions")
    val budgetInMillions: Double,
    @field:Json(name = "boxOfficeRevenueInMillions")
    val boxOfficeRevenueInMillions: Double,
    @field:Json(name = "academyAwardNominations")
    val academyAwardNominations: Int,
    @field:Json(name = "academyAwardWins")
    val academyAwardWins: Int,
    @field:Json(name = "rottenTomatoesScore")
    val rottenTomatoesScore: Double,
    @field:Json(name="wikiUrl")
    var wikiUrl : String = "",
    var favorite : Boolean = false,
)