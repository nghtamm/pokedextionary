package com.nghtamm.pokedextionary.features.pokedex.data.repository

import com.nghtamm.pokedextionary.core.network.NetworkService
import com.nghtamm.pokedextionary.features.pokedex.data.models.PokemonListResponse

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
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}