package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.movies

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.domain.model.movies.Data
import javax.inject.Inject

class MovieDataMapper @Inject constructor() :
    Transform<com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Data, Data>() {
    override fun transform(value: com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Data): Data {
        return value.let {
            Data(
                it.count.value(),
                it.limit.value(),
                it.offset.value(),
                results = it.results,
                it.total.value(),
            )
        }
    }
}