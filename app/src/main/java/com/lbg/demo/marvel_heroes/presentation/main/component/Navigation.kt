@file:OptIn(ExperimentalCoilApi::class)

package com.lbg.demo.marvel_heroes.presentation.main.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.presentation.SplashScreen
import com.lbg.demo.marvel_heroes.presentation.hero_detail.components.HeroDetailScreen
import com.lbg.demo.marvel_heroes.presentation.heroes_list.components.HeroesListScreen
import com.lbg.demo.marvel_heroes.presentation.movies_list.components.MoviesListScreen
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.SPLASH_SCREEN

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SPLASH_SCREEN) {

        composable(NavigationConstants.SPLASH_SCREEN){
            SplashScreen(navController)
        }

        composable(NavigationConstants.HEROES_LIST_SCREEN) {
            HeroesListScreen(navController)
        }
        
        composable(NavigationConstants.MOVIE_LIST_SCREEN){
            MoviesListScreen(navController = navController)
        }

        composable(
            NavigationConstants.HERO_DETAIL_SCREEN_ROUTE,
            arguments = listOf(
                navArgument(NavigationConstants.DOMINANT_COLOR) { type = NavType.IntType },
                navArgument(NavigationConstants.HERO_ID) { type = NavType.StringType }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt(NavigationConstants.DOMINANT_COLOR)
                color?.let { Color(it) } ?: Color.White
            }

            val characterId = remember {
                it.arguments?.getString(NavigationConstants.HERO_ID)
            }

            HeroDetailScreen(navController, characterId.value(), dominantColor)
        }
    }
}
