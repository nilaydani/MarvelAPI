package com.lbg.demo.marvel_heroes.domain.model.movies

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)