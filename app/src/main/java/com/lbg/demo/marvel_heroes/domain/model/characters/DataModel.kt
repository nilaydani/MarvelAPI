package com.lbg.demo.marvel_heroes.domain.model.characters

import com.lbg.demo.core.util.Constants.ZERO

data class DataModel(
    val count: Int = ZERO,
    val limit: Int = ZERO,
    val offset: Int = ZERO,
    val resultModels: List<ResultModel> = listOf(),
    val total: Int = ZERO
)