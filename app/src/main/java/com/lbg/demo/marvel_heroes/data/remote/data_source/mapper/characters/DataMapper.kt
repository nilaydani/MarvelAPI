package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.DataDto
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.ResultDto
import com.lbg.demo.marvel_heroes.domain.model.characters.DataModel
import com.lbg.demo.marvel_heroes.domain.model.characters.ResultModel
import javax.inject.Inject

class DataMapper @Inject constructor(private val resultMapper: Transform<ResultDto, ResultModel>) :
    Transform<DataDto?, DataModel>() {

    override fun transform(value: DataDto?): DataModel {
        return value?.let {
            DataModel(
                it.count.value(),
                it.limit.value(),
                it.offset.value(),
                resultMapper.transformCollection(it.results ?: listOf()),
                it.total.value(),
            )
        } ?: DataModel()
    }
}