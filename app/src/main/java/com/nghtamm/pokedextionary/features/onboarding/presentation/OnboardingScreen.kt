package com.nghtamm.pokedextionary.features.onboarding.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OnboardingScreen(onNext: () -> Unit) {
    Button(onClick = onNext) {
        Text("Go to Pokedex")
    }
}