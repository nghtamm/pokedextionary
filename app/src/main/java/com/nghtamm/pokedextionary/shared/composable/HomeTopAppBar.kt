package com.nghtamm.pokedextionary.shared.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.nghtamm.pokedextionary.core.theme.*

@ExperimentalMaterial3Api
@Composable
fun HomeTopAppBar(
    title: String,
    onTitleClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LightPrimary,
            titleContentColor = LightPrimary
        ),
        title = {
            Text(
                text = "$title \t ▾",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = PastelRed,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onTitleClick
                )
            )
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }
    )
}
