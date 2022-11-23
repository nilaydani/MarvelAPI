package com.lbg.demo.marvel_heroes.domain.model.characters

import com.lbg.demo.core.util.Constants.EMPTY_STRING

data class ThumbnailModel(
    val extension: String = EMPTY_STRING,
    val path: String= EMPTY_STRING
)