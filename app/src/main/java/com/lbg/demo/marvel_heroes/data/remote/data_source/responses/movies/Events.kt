package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)