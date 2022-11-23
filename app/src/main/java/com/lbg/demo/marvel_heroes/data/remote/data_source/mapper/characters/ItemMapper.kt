/*
 * ItemMapper.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 19:44
 */

package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.ItemDto
import com.lbg.demo.marvel_heroes.domain.model.characters.ItemModel

class ItemMapper : Transform<ItemDto, ItemModel>() {

    override fun transform(value: ItemDto): ItemModel =
        with(value) { ItemModel(name.value(), resourceURI.value()) }
}