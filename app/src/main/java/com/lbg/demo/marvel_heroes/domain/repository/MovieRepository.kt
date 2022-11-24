package com.lbg.demo.marvel_heroes.domain.repository

import com.lbg.demo.core.data.Resource
import com.lbg.demo.marvel_heroes.domain.model.movies.MoviesResponseModel

interface MovieRepository {
    suspend fun getMovies(limit: Int, offset: Int): Resource<MoviesResponseModel>
}