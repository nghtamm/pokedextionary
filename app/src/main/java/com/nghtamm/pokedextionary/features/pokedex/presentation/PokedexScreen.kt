package com.nghtamm.pokedextionary.features.pokedex.presentation

import androidx.activity.compose.LocalActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.nghtamm.pokedextionary.core.theme.LightPrimary

@Composable
fun PokedexScreen() {
    val window = (LocalActivity.current)?.window
    SideEffect {
        window?.let {
            @Suppress("DEPRECATION")
            it.statusBarColor = LightPrimary.toArgb()
            @Suppress("DEPRECATION")
            it.navigationBarColor = LightPrimary.toArgb()

            WindowCompat.getInsetsController(it, it.decorView)
                .isAppearanceLightStatusBars = true
        }
    }

    Text(
        text = "Placeholder"
    )
}