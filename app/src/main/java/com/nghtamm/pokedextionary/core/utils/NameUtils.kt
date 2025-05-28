package com.nghtamm.pokedextionary.core.utils

object NameUtils {
    private val nameMap: Map<String, String> = mapOf(
        "nidoran-f" to "Nidoran♀",
        "nidoran-m" to "Nidoran♂",
        "farfetchd" to "Farfetch'd",
        "mr-mime" to "Mr. Mime",
        "ho-oh" to "Ho-Oh",
        "mime-jr" to "Mime Jr.",
        "porygon-z" to "Porygon-Z",
        "type-null" to "Type: Null",
        "jangmo-o" to "Jangmo-o",
        "hakamo-o" to "Hakamo-o",
        "kommo-o" to "Kommo-o",
        "sirfetchd" to "Sirfetch'd",
        "mr-rime" to "Mr. Rime",
        "wo-chien" to "Wo-Chien",
        "chien-pao" to "Chien-Pao",
        "ting-lu" to "Ting-Lu",
        "chi-yu" to "Chi-Yu"
    )

    fun formatPokemonName(name: String): String {
        return nameMap[name.lowercase()] ?: name
            .split('-')
            .joinToString(" ") {
                it.replaceFirstChar { char ->
                    char.uppercase()
                }
            }
    }
}