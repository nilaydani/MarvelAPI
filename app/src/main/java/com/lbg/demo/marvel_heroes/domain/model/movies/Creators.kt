package com.lbg.demo.marvel_heroes.domain.model.movies

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)