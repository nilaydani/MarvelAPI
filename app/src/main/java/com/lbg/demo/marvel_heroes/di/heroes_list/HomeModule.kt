/*
 * HomeModule.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 17:44
 */

package com.lbg.demo.marvel_heroes.di.heroes_list

import com.lbg.demo.marvel_heroes.domain.repository.MarvelCharacterRepository
import com.lbg.demo.marvel_heroes.domain.use_case.home.GetHeroesListUseCase
import com.lbg.demo.marvel_heroes.domain.use_case.images.CalcDominantColorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideGetHeroesListUseCase(repository: MarvelCharacterRepository): GetHeroesListUseCase {
        return GetHeroesListUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCalculateDominantColorUseCase(): CalcDominantColorUseCase {
        return CalcDominantColorUseCase()
    }
}