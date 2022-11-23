/*
 * UrlMapper.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 19:45
 */

package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.UrlDto
import com.lbg.demo.marvel_heroes.domain.model.characters.UrlModel

class UrlMapper : Transform<UrlDto, UrlModel>() {

    override fun transform(value: UrlDto): UrlModel =
        with(value) { UrlModel(type.value(), url.value()) }
}