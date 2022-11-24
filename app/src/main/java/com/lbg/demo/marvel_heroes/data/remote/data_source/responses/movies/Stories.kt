package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)