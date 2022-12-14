package com.lbg.demo.marvel_heroes.presentation.hero_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lbg.demo.R
import com.lbg.demo.core.data.Resource
import com.lbg.demo.core.extensions.value
import com.lbg.demo.core.util.Constants
import com.lbg.demo.marvel_heroes.domain.model.characters.ResultModel
import com.lbg.demo.marvel_heroes.domain.model.hero_detail.CharacterStatModel
import com.lbg.demo.marvel_heroes.domain.use_case.hero_detail.GetHeroDetailUseCase
import com.lbg.demo.marvel_heroes.domain.use_case.images.CalcDominantColorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val getHeroDetailUseCase: GetHeroDetailUseCase,
    private val getCalcDominantColorUseCase: CalcDominantColorUseCase
) : ViewModel() {

    var heroEntry = mutableStateOf(ResultModel())
    var characterStats = mutableStateOf<List<CharacterStatModel>>(listOf())
    var loadError = mutableStateOf(Constants.EMPTY_STRING)
    var isLoading = mutableStateOf(false)

    fun getCharacterDetail(characterId: String) {
        isLoading.value = true

        viewModelScope.launch {
            when (val result = getHeroDetailUseCase.invoke(characterId)) {
                is Resource.Success -> {
                    if (result.data?.dataModel != null) {
                        updateVariableStates(result.data.dataModel.resultModels.first())
                    }
                }
                is Resource.Error -> {
                    loadError.value = result.message.value()
                    isLoading.value = false
                }
                else -> Unit
            }
        }
    }

    fun getCharacterStatsList(heroEntry: ResultModel): List<CharacterStatModel> {
        return listOf(
            CharacterStatModel(
                R.drawable.ic_comic,
                R.string.comics,
                heroEntry.comicsModel.available
            ),
            CharacterStatModel(
                R.drawable.ic_series,
                R.string.series,
                heroEntry.seriesModel.available
            ),
            CharacterStatModel(
                R.drawable.ic_stories,
                R.string.stories,
                heroEntry.storiesModel.available
            ),
            CharacterStatModel(
                R.drawable.ic_events,
                R.string.events,
                heroEntry.eventsModel.available
            )
        )
    }

    private fun updateVariableStates(heroEntry: ResultModel) {
        loadError.value = Constants.EMPTY_STRING
        isLoading.value = false
        this.heroEntry.value = heroEntry
    }
}