package com.lbg.demo.marvel_heroes.domain.model.movies

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)