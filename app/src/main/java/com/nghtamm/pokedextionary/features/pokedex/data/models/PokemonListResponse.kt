package com.nghtamm.pokedextionary.features.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class PokemonList(
    val id: String,
    val name: String,
    val sprite: String,
    val types: List<String>
)

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<Result>
) {
    data class Result(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    )
}