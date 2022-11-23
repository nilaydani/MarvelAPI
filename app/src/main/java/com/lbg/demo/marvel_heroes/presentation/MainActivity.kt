package com.lbg.demo.marvel_heroes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.presentation.hero_detail.components.HeroDetailScreen
import com.lbg.demo.marvel_heroes.presentation.heroes_list.components.HeroesListScreen
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.DOMINANT_COLOR
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.HEROES_LIST_SCREEN
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.HERO_DETAIL_SCREEN_ROUTE
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.HERO_ID
import com.lbg.demo.marvel_heroes.presentation.util.NavigationConstants.SPLASH_SCREEN
import com.lbg.demo.ui.theme.MarvelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MarvelAppTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize(), content = {
                        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            NavHost(navController = navController, startDestination = SPLASH_SCREEN) {

                                composable(SPLASH_SCREEN){
                                    SplashScreen(navController)
                                }

                                composable(HEROES_LIST_SCREEN) {
                                    HeroesListScreen(navController)
                                }

                                composable(
                                    HERO_DETAIL_SCREEN_ROUTE,
                                    arguments = listOf(
                                        navArgument(DOMINANT_COLOR) { type = NavType.IntType },
                                        navArgument(HERO_ID) { type = NavType.StringType }
                                    )
                                ) {
                                    val dominantColor = remember {
                                        val color = it.arguments?.getInt(DOMINANT_COLOR)
                                        color?.let { Color(it) } ?: Color.White
                                    }

                                    val characterId = remember {
                                        it.arguments?.getString(HERO_ID)
                                    }

                                    HeroDetailScreen(navController, characterId.value(), dominantColor)
                                }
                            }

                        }
                    })

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarvelAppTheme {
        Greeting("Android")
    }
}