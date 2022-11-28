package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters

data class StoriesDto(
    val available: Int?,
    val collectionURI: String?,
    val items: List<StoryItemDto>?,
    val returned: Int?
)