package com.nghtamm.pokedextionary.features.onboarding.data.local

import androidx.annotation.DrawableRes
import com.nghtamm.pokedextionary.R

data class OnboardingData(
    @DrawableRes val image: Int? = null,
    val title: String,
    val content: String? = null
)

val pagesData = listOf(
    OnboardingData(
        image = R.drawable.pokemon_logo,
        title = "A refined all-in-one Pokédex"
    ),
    OnboardingData(
        title = "Disclaimer",
        content = """
            PokéDextionary is an unofficial, fan-made application and is not affiliated with, endorsed, sponsored or approved by Nintendo, GAME FREAK Inc. or The Pokémon Company.

            All Pokémon-related content including names, characters, images, game data and other intellectual property are copyrighted and trademarked by Nintendo, GAME FREAK Inc. and The Pokémon Company. These materials are used in this app in accordance with the laws of Fair Use. PokéDextionary does not claim ownership of any Pokémon-related intellectual property. No copyright/trademark infringement is intended.

            Pokémon © 2002-2025 Pokémon
            © 1995–2025 Nintendo/Creatures Inc./GAME FREAK Inc.
        """.trimIndent()
    ),
    OnboardingData(
        image = R.drawable.hilda_sprite,
        title = "Let us be your guide on the journey to becoming a Pokémon Master!"
    ),
)