package com.nghtamm.pokedextionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nghtamm.pokedextionary.core.navigation.Application
import com.nghtamm.pokedextionary.core.theme.PokedextionaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedextionaryTheme {
                Application()
            }
        }
    }
}