package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters

data class ResultDto(
    val comics: ComicsDto?,
    val description: String?,
    val events: EventsDto?,
    val id: Int?,
    val modified: String?,
    val name: String?,
    val resourceURI: String?,
    val series: SeriesDto?,
    val stories: StoriesDto?,
    val thumbnail: ThumbnailDto?,
    val urls: List<UrlDto>?
)