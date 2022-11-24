package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class MoviesResponseModelDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)