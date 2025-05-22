package com.nghtamm.pokedextionary.shared.data

import androidx.compose.ui.graphics.Brush
import com.nghtamm.pokedextionary.R
import com.nghtamm.pokedextionary.core.navigation.Screen
import com.nghtamm.pokedextionary.core.theme.*

data class HomeNavigationData(
    val title: String,
    val color: Brush,
    val image: Int,
    val route: String
)

val navigationItems = listOf(
    HomeNavigationData(
        title = "Pokédex",
        color = Brush.linearGradient(
            listOf(
                CoralRed.copy(alpha = 0.8f),
                PastelRed
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    ),
    HomeNavigationData(
        title = "Moves",
        color = Brush.linearGradient(
            listOf(
                PastelOrange.copy(alpha = 0.9f),
                PastelYellow
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    ),
    HomeNavigationData(
        title = "Items",
        color = Brush.linearGradient(
            listOf(
                NeutralGray.copy(alpha = 0.9f),
                PlatinumGray
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    ),
    HomeNavigationData(
        title = "Types",
        color = Brush.linearGradient(
            listOf(
                MauvePurple.copy(alpha = 0.8f),
                PastelPurple
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    ),
    HomeNavigationData(
        title = "Abilities",
        color = Brush.linearGradient(
            listOf(
                SkyBlue.copy(alpha = 0.8f),
                PastelBlue
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    ),
    HomeNavigationData(
        title = "Natures",
        color = Brush.linearGradient(
            listOf(
                MintGreen.copy(alpha = 0.8f),
                PastelGreen
            )
        ),
        image = R.drawable.pokeball,
        route = Screen.Pokedex.route
    )
)