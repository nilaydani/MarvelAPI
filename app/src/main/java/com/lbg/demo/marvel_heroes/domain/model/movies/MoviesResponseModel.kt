package com.lbg.demo.marvel_heroes.domain.model.movies

data class MoviesResponseModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)