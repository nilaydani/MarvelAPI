package com.lbg.demo.marvel_heroes.domain.model.characters

data class CharacterResponseModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val dataModel: DataModel,
    val eTag: String,
    val status: String
)