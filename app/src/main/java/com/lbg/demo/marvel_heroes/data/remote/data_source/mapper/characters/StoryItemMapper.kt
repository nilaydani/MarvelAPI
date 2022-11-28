package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.StoryItemDto
import com.lbg.demo.marvel_heroes.domain.model.characters.StoryItemModel

class StoryItemMapper : Transform<StoryItemDto, StoryItemModel>() {

    override fun transform(value: StoryItemDto): StoryItemModel =
        with(value) { StoryItemModel(name.value(), resourceURI.value(), type.value()) }
}