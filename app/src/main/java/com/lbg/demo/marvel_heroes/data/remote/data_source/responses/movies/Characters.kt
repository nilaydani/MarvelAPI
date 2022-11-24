package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)