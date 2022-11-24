package com.lbg.demo.marvel_heroes.data.repository

import com.lbg.demo.core.data.Resource
import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.marvel_heroes.data.remote.data_source.MarvelApi
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.MoviesResponseModelDto
import com.lbg.demo.marvel_heroes.data.remote.data_source.util.ApiEndpoint
import com.lbg.demo.marvel_heroes.data.remote.data_source.util.HashBuilder
import com.lbg.demo.marvel_heroes.domain.model.movies.MoviesResponseModel
import com.lbg.demo.marvel_heroes.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MarvelMovieRepositoryImpl @Inject constructor(
    private val apiInstance: MarvelApi,
    private val movieResponseMapper: Transform<MoviesResponseModelDto, MoviesResponseModel>
) : MovieRepository {
    override suspend fun getMovies(limit: Int, offset: Int): Resource<MoviesResponseModel> {
        val response = try {
            HashBuilder().build().run {
                apiInstance.getMoviesList(
                    limit, offset, timeStamp, ApiEndpoint.PUBLIC_API_KEY, hash
                )
            }
        } catch (e: Exception) {
            return Resource.Error("Unknown Error: ${e.message}")
        }

        return Resource.Success(movieResponseMapper.transform(response))
    }


}