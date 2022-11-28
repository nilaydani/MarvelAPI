package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters

data class DataDto(
    val count: Int?,
    val limit: Int?,
    val offset: Int?,
    val results: List<ResultDto>?,
    val total: Int?
)