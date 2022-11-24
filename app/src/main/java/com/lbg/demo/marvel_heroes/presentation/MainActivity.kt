@file:OptIn(ExperimentalCoilApi::class)

package com.lbg.demo.marvel_heroes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.lbg.demo.core.extensions.value
import com.lbg.demo.marvel_heroes.presentation.main.component.BottomNavigationBar
import com.lbg.demo.marvel_heroes.presentation.main.component.Navigation
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

                MainScreen()

            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = {
            Surface(color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize(), content = {
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Navigation(navController = navController)
                    }
                })

        },
        backgroundColor = White // Set background color to avoid the white flashing when you switch between screens
    )
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