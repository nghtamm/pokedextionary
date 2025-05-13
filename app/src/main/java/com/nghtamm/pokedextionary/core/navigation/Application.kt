package com.nghtamm.pokedextionary.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.nghtamm.pokedextionary.core.theme.PokedextionaryTheme

@Composable
fun Application() {
    val navController = rememberNavController()
    PokedextionaryTheme {
        NavigationHost(
            navController = navController,
            startDestination = Screen.Onboarding.route
        )
    }
}