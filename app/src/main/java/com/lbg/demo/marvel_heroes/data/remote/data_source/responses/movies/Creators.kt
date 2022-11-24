package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)