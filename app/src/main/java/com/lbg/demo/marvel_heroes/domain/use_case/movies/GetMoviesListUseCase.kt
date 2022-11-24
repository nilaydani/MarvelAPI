/*
 * GetHeroesListUseCase.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 20:42
 */

package com.lbg.demo.marvel_heroes.domain.use_case.movies

import com.lbg.demo.core.data.Resource
import com.lbg.demo.marvel_heroes.domain.model.movies.MoviesResponseModel
import com.lbg.demo.marvel_heroes.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(limit: Int, offset: Int): Resource<MoviesResponseModel> {
        return repository.getMovies(limit, offset)
    }
}