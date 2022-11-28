package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.CharacterResponseDto
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.DataDto
import com.lbg.demo.marvel_heroes.domain.model.characters.CharacterResponseModel
import com.lbg.demo.marvel_heroes.domain.model.characters.DataModel
import javax.inject.Inject

class CharacterResponseMapper @Inject constructor(
    private val dataMapper: Transform<DataDto?, DataModel>
) : Transform<CharacterResponseDto, CharacterResponseModel>() {

    override fun transform(value: CharacterResponseDto): CharacterResponseModel {
        return with(value) {
            CharacterResponseModel(
                attributionHTML.value(),
                attributionText.value(),
                code.value(),
                copyright.value(),
                dataMapper.transform(data),
                etag.value(),
                status.value(),
            )
        }
    }
}