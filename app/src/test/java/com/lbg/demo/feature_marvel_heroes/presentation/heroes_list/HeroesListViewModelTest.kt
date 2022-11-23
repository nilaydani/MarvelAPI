/*
 * HeroesListViewModelTest.kt
 * Personal App Android
 * Created by Alan Hernández on 26/03/22 17:00
 */

package com.lbg.demo.feature_marvel_heroes.presentation.heroes_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lbg.demo.dispatchers.StandardDispatchersTest
import com.lbg.demo.feature_marvel_heroes.data.remote.data_source.mapper.characters.mocks.CharactersMocks
import com.lbg.demo.marvel_heroes.domain.repository.MarvelCharacterRepository
import com.lbg.demo.marvel_heroes.domain.use_case.home.GetHeroesListUseCase
import com.lbg.demo.marvel_heroes.domain.use_case.images.CalcDominantColorUseCase
import com.lbg.demo.marvel_heroes.presentation.heroes_list.HeroesListViewModel
import com.lbg.demo.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner.StrictStubs::class)
class HeroesListViewModelTest() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var repository: MarvelCharacterRepository

    private val getHeroesListUseCase:
            GetHeroesListUseCase by lazy { GetHeroesListUseCase(repository) }

    private val calcDominant by lazy { mock(CalcDominantColorUseCase::class.java) }
    private val standardDispatcherTest by lazy { StandardDispatchersTest() }
    private val characterMocks = CharactersMocks()
    private lateinit var viewModel: HeroesListViewModel

    @Before
    fun setup(){
        runTest {
            Mockito.`when`(repository.getMarvelCharactersList(20,0)).thenReturn(
                characterMocks.getResourceSuccess()
            )
            viewModel = HeroesListViewModel(getHeroesListUseCase,calcDominant,standardDispatcherTest)
        }
    }

    @Test
    fun test() {
        runTest {
         Assert.assertEquals(1, viewModel.heroesList.value.size)
        }

    }
}