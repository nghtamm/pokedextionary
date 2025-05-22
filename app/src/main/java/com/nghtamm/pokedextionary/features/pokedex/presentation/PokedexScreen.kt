package com.nghtamm.pokedextionary.features.pokedex.presentation

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.nghtamm.pokedextionary.core.theme.LightPrimary
import com.nghtamm.pokedextionary.shared.composable.*

@ExperimentalMaterial3Api
@Composable
fun PokedexScreen(
    navController: NavHostController
) {
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

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = LightPrimary,
        topBar = {
            HomeTopAppBar(
                title = "Pokédex",
                onTitleClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { padding ->
        if (showBottomSheet) {
            HomeBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                navController = navController
            )
        }

        Column(
            modifier = Modifier.padding(padding)
        ) {
            Text("Placeholder")
        }
    }
}

