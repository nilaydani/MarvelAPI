/*
 * CharacterResponseMapper.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 19:41
 */
package com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.movies

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.MoviesResponseModelDto
import com.lbg.demo.marvel_heroes.domain.model.movies.Data
import com.lbg.demo.marvel_heroes.domain.model.movies.MoviesResponseModel
import javax.inject.Inject

class MovieResponseMapper @Inject constructor(
    private val dataMapper: Transform<com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Data, Data>
) : Transform<MoviesResponseModelDto, MoviesResponseModel>() {

    override fun transform(value: MoviesResponseModelDto): MoviesResponseModel {
        return with(value) {
            MoviesResponseModel(
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