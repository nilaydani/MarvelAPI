/*
 * Series.kt
 * Personal App Android
 * Created by Alan Hernández on 17/01/22 15:01
 */

package com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters

import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.ItemDto

data class SeriesDto(
    val available: Int?,
    val collectionURI: String?,
    val items: List<ItemDto>?,
    val returned: Int?
)