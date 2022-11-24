/*
 * HeroesListViewModel.kt
 * Personal App Android
 * Created by Alan Hernández on 25/01/22 21:50
 */

package com.lbg.demo.marvel_heroes.presentation.movies_list

import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lbg.demo.core.data.Resource
import com.lbg.demo.core.extensions.value
import com.lbg.demo.core.presentation.dispatchers.DispatcherProvider
import com.lbg.demo.core.util.Constants.EMPTY_STRING
import com.lbg.demo.core.util.Constants.ZERO
import com.lbg.demo.marvel_heroes.domain.use_case.images.CalcDominantColorUseCase
import com.lbg.demo.marvel_heroes.domain.use_case.movies.GetMoviesListUseCase
import com.lbg.demo.marvel_heroes.presentation.util.PresentationUtils.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val getMoviesListUseCase: GetMoviesListUseCase,
    private val getCalcDominantColorUseCase: CalcDominantColorUseCase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    var movieList = mutableStateOf<List<com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Result>>(listOf())
    var loadError = mutableStateOf(EMPTY_STRING)
    var isLoading = mutableStateOf(false)
    var endReach = mutableStateOf(false)
    var isSearching = mutableStateOf(false)

    private var currentPage = ZERO
    private var moviesList = listOf<com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Result>()
    private var isSearchStarting = true

    init {
        loadMoviesPaginated()
    }

    fun searchCharactersList(query: String) {
        val listToSearch = if (isSearchStarting) {
            movieList.value
        } else {
            moviesList
        }

        viewModelScope.launch(dispatchers.default) {
            if (query.isEmpty()) {
                movieList.value = moviesList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }

            val results = listToSearch.filter {
                it.title.contains(query.trim(), ignoreCase = true)
            }

            if(isSearchStarting){
                moviesList = movieList.value
                isSearchStarting = false
            }

            movieList.value = results
            isSearching.value = true
        }
    }

    fun loadMoviesPaginated() {
        isLoading.value = true

        viewModelScope.launch {
            when (val result = getMoviesListUseCase.invoke(PAGE_SIZE, getOffset())) {
                is Resource.Success -> {
                    if (result.data?.data != null) {
                        updateEndReach(result.data.data.total.value())
                        updateVariablesStates(result.data.data.results)
                    }
                }
                is Resource.Error -> {
                    loadError.value = result.message.value()
                    isLoading.value = false
                }
                else -> {
                    isLoading.value = false
                }
            }
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        getCalcDominantColorUseCase.invoke(drawable, onFinish)
    }

    private fun getOffset(): Int {
        return currentPage * PAGE_SIZE
    }

    private fun updateEndReach(listCount: Int) {
        endReach.value = currentPage * PAGE_SIZE >= listCount
    }

    private fun updateVariablesStates(moviessList: List<com.lbg.demo.marvel_heroes.data.remote.data_source.responses.movies.Result>) {
        currentPage++
        loadError.value = EMPTY_STRING
        isLoading.value = false
        movieList.value += moviessList
    }
}