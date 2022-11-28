package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.UrlDto
import com.lbg.demo.marvel_heroes.domain.model.characters.UrlModel

class UrlMapper : Transform<UrlDto, UrlModel>() {

    override fun transform(value: UrlDto): UrlModel =
        with(value) { UrlModel(type.value(), url.value()) }
}