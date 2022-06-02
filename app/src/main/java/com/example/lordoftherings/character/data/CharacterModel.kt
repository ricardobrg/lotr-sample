package com.example.lordoftherings.character.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "characters")
@JsonClass(generateAdapter = true)
data class CharacterModel constructor(
    @PrimaryKey
    @field:Json(name = "_id")
    val id: String,
    @field:Json(name="height")
    val height : String,
    @field:Json(name="race")
    val race : String,
    @field:Json(name="gender")
    var gender : String = "",
    @field:Json(name="birth")
    val birth : String,
    @field:Json(name="spouse")
    val spouse : String,
    @field:Json(name="death")
    val death : String,
    @field:Json(name="realm")
    val realm : String,
    @field:Json(name="hair")
    val hair : String,
    @field:Json(name="name")
    val name : String,
    @field:Json(name="wikiUrl")
    var wikiUrl : String = "",
)