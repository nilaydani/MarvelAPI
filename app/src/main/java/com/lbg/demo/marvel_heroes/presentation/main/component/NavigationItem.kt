package com.lbg.demo.marvel_heroes.presentation.main.component

import com.lbg.demo.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Characters : NavigationItem("hero_list_screen", R.drawable.ic_comic, "Characters")
    object Movies : NavigationItem("movie_list_screen", R.drawable.ic_movie, "Movies")
}
