package com.nghtamm.pokedextionary.core.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.nghtamm.pokedextionary.R
import com.nghtamm.pokedextionary.core.theme.*

data class TypeStyle(
    val color: Color,
    val backgroundColor: Color,
    val icon: Int
)

object TypeUtils {
    private val typeMap: Map<String, TypeStyle> = mapOf(
        "normal" to TypeStyle(Normal, NormalLight, R.drawable.normal),
        "fire" to TypeStyle(Fire, FireLight, R.drawable.fire),
        "water" to TypeStyle(Water, WaterLight, R.drawable.water),
        "electric" to TypeStyle(Electric, ElectricLight, R.drawable.electric),
        "grass" to TypeStyle(Grass, GrassLight, R.drawable.grass),
        "ice" to TypeStyle(Ice, IceLight, R.drawable.ice),
        "fighting" to TypeStyle(Fighting, FightingLight, R.drawable.fighting),
        "poison" to TypeStyle(Poison, PoisonLight, R.drawable.poison),
        "ground" to TypeStyle(Ground, GroundLight, R.drawable.ground),
        "flying" to TypeStyle(Flying, FlyingLight, R.drawable.flying),
        "psychic" to TypeStyle(Psychic, PsychicLight, R.drawable.psychic),
        "bug" to TypeStyle(Bug, BugLight, R.drawable.bug),
        "rock" to TypeStyle(Rock, RockLight, R.drawable.rock),
        "ghost" to TypeStyle(Ghost, GhostLight, R.drawable.ghost),
        "dragon" to TypeStyle(Dragon, DragonLight, R.drawable.dragon),
        "dark" to TypeStyle(Dark, DarkLight, R.drawable.dark),
        "steel" to TypeStyle(Steel, SteelLight, R.drawable.steel),
        "fairy" to TypeStyle(Fairy, FairyLight, R.drawable.fairy),
        "stellar" to TypeStyle(Stellar, StellarLight, R.drawable.stellar),
        "unknown" to TypeStyle(Unknown, UnknownLight, R.drawable.pokeball)
    )

    @Composable
    fun getTypeStyle(type: String): TypeStyle {
        return typeMap[type.lowercase()] ?: TypeStyle(
            color = MaterialTheme.colorScheme.primary,
            backgroundColor = LightPrimary,
            icon = R.drawable.pokeball
        )
    }
}