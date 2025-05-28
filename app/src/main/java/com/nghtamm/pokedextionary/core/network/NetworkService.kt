package com.nghtamm.pokedextionary.core.network

import com.nghtamm.pokedextionary.features.pokedex.data.models.*
import retrofit2.http.*

interface NetworkService {
    @GET("pokemon-species")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: String
    ): PokemonResponse
}