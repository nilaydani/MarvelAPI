/*
 * HomeModule.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 17:44
 */

package com.lbg.demo.marvel_heroes.di.movies_list

import com.lbg.demo.marvel_heroes.domain.repository.MovieRepository
import com.lbg.demo.marvel_heroes.domain.use_case.movies.GetMoviesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideGetMoviesListUseCase(repository: MovieRepository): GetMoviesListUseCase {
        return GetMoviesListUseCase(repository)
    }
}