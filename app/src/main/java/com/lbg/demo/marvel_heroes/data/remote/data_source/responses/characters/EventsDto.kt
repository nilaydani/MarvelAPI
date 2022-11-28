package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters

data class EventsDto(
    val available: Int?,
    val collectionURI: String?,
    val items: List<ItemDto>?,
    val returned: Int?
)