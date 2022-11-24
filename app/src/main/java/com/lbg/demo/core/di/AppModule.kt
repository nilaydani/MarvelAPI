package com.lbg.demo.core.di

import com.lbg.demo.core.domain.mapper.Transform
import com.lbg.demo.core.presentation.dispatchers.DispatcherProvider
import com.lbg.demo.core.presentation.dispatchers.StandardDispatchers
import com.lbg.demo.marvel_heroes.data.remote.data_source.MarvelApi
import com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.characters.*
import com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.movies.MovieDataMapper
import com.lbg.demo.marvel_heroes.data.remote.data_source.mapper.movies.MovieResponseMapper
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.characters.*
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Data
import com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.MoviesResponseModelDto
import com.lbg.demo.marvel_heroes.data.remote.data_source.util.ApiEndpoint
import com.lbg.demo.marvel_heroes.data.remote.data_source.util.ApiHelper
import com.lbg.demo.marvel_heroes.data.repository.MarvelCharacterRepositoryImpl
import com.lbg.demo.marvel_heroes.data.repository.MarvelMovieRepositoryImpl
import com.lbg.demo.marvel_heroes.domain.model.characters.*
import com.lbg.demo.marvel_heroes.domain.model.movies.MoviesResponseModel
import com.lbg.demo.marvel_heroes.domain.repository.MarvelCharacterRepository
import com.lbg.demo.marvel_heroes.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUrlMapper(): Transform<UrlDto, UrlModel> {
        return UrlMapper()
    }

    @Provides
    @Singleton
    fun provideItemMapper(): Transform<ItemDto, ItemModel> {
        return ItemMapper()
    }

    @Provides
    @Singleton
    fun provideStoryItemMapper(): Transform<StoryItemDto, StoryItemModel> {
        return StoryItemMapper()
    }

    @Provides
    @Singleton
    fun provideResultMapper(
        itemMapper: Transform<ItemDto, ItemModel>,
        storyItemMapper: Transform<StoryItemDto, StoryItemModel>,
        urlMapper: Transform<UrlDto, UrlModel>
    ): Transform<ResultDto, ResultModel> {
        return ResultMapper(itemMapper, storyItemMapper, urlMapper)
    }

    @Provides
    @Singleton
    fun provideDataMapper(resultMapper: Transform<ResultDto, ResultModel>):
            Transform<DataDto?, DataModel> {
        return DataMapper(resultMapper)
    }

    @Provides
    @Singleton
    fun provideMovieDataMapper():
            Transform<Data, com.lbg.demo.marvel_heroes.domain.model.movies.Data> {
        return MovieDataMapper()
    }

    @Provides
    @Singleton
    fun provideCharacterResponseMapper(dataMapper: Transform<DataDto?, DataModel>):
            Transform<CharacterResponseDto, CharacterResponseModel> {
        return CharacterResponseMapper(dataMapper)
    }

    @Provides
    @Singleton
    fun provideMovieResponseMapper(dataMapper: Transform<Data, com.lbg.demo.marvel_heroes.domain.model.movies.Data>):
            Transform<MoviesResponseModelDto, MoviesResponseModel> {
        return MovieResponseMapper(dataMapper)
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(ApiEndpoint.MARVEL_BASE_URL)
        .client(ApiHelper.getOkHttpClientWithStethoAndLoggingInterceptor())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideMarvelApi(retrofitInstance: Retrofit): MarvelApi =
        retrofitInstance.create(MarvelApi::class.java)

    @Singleton
    @Provides
    fun provideMarvelRepository(
        marvelApi: MarvelApi,
        characterResponseMapper: Transform<CharacterResponseDto, CharacterResponseModel>
    ): MarvelCharacterRepository = MarvelCharacterRepositoryImpl(marvelApi, characterResponseMapper)

    @Singleton
    @Provides
    fun provideMarvelMovieRepository(
        marvelApi: MarvelApi,
        movieResponseMapper: Transform<MoviesResponseModelDto, MoviesResponseModel>
    ): MovieRepository = MarvelMovieRepositoryImpl(marvelApi, movieResponseMapper)


    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return StandardDispatchers()
    }
}