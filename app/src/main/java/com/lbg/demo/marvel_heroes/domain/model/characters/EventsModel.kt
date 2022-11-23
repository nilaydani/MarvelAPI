package com.lbg.demo.marvel_heroes.domain.model.characters

import com.lbg.demo.core.util.Constants.EMPTY_STRING
import com.lbg.demo.core.util.Constants.ZERO
import com.lbg.demo.marvel_heroes.domain.model.characters.ItemModel

data class EventsModel(
    val available: Int = ZERO,
    val collectionURI: String = EMPTY_STRING,
    val itemModels: List<ItemModel> = listOf(),
    val returned: Int= ZERO
)