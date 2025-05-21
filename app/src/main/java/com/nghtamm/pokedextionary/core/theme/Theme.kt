package com.nghtamm.pokedextionary.core.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun PokedextionaryTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = PokedextionaryTypography,
        content = content
    )
}