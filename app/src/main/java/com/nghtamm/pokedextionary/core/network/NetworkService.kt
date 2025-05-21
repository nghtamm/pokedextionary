package com.nghtamm.pokedextionary.core.network

import retrofit2.Response
import retrofit2.http.*

interface NetworkService {
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ): Response<Any>
}