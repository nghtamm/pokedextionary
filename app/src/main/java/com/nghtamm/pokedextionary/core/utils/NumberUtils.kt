package com.nghtamm.pokedextionary.core.utils

object NumberUtils {
    fun formatPokemonNumber(id: String): String {
        return "#${id.toString().padStart(4, '0')}"
    }
}