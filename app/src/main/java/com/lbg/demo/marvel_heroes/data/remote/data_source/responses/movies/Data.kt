package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)