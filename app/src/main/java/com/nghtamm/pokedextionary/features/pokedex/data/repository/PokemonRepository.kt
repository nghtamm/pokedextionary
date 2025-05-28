package com.nghtamm.pokedextionary.features.pokedex.data.repository

import com.nghtamm.pokedextionary.core.network.NetworkService
import com.nghtamm.pokedextionary.features.pokedex.data.models.*

class PokemonRepository(
    private val service: NetworkService
) {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Result<PokemonListResponse> {
        return try {
            val response = service.getPokemonList(limit, offset)
            Result.success(response)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    suspend fun getPokemon(name: String): Result<PokemonResponse> {
        return try {
            val response = service.getPokemon(name)
            Result.success(response)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}