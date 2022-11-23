package com.lbg.demo.marvel_heroes.domain.model.characters

import com.lbg.demo.core.util.Constants.EMPTY_STRING
import com.lbg.demo.core.util.Constants.ZERO

data class StoriesModel(
    val available: Int= ZERO,
    val collectionURI: String = EMPTY_STRING,
    val storyItemModels: List<StoryItemModel> = listOf(),
    val returned: Int= ZERO
)