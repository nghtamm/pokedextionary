package com.nghtamm.pokedextionary.core.network

import com.nghtamm.pokedextionary.features.pokedex.data.models.*
import retrofit2.http.*

interface NetworkService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): PokemonResponse
}