package com.lbg.demo.marvel_heroes.domain.model.movies

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)