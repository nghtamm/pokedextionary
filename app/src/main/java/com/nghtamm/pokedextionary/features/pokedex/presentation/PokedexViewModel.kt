package com.nghtamm.pokedextionary.features.pokedex.presentation

import android.util.Log
import androidx.lifecycle.*
import com.nghtamm.pokedextionary.core.network.ExceptionHandler
import com.nghtamm.pokedextionary.features.pokedex.data.models.PokemonList
import com.nghtamm.pokedextionary.features.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PokedexViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _state = MutableStateFlow<PokedexState>(PokedexState.Loading)
    val state: StateFlow<PokedexState> = _state

    fun getPokemonList(
        limit: Int = 100000,
        offset: Int = 0
    ) {
        _state.value = PokedexState.Loading
        viewModelScope.launch {
            val result = repository.getPokemonList(limit, offset)
            result.onSuccess {
                val pokemonList = it.results.map { item ->
                    async {
                        try {
                            val pokemon = repository
                                .getPokemon(
                                    item.url
                                        .trimEnd('/')
                                        .split("/")
                                        .last()
                                )
                                .getOrNull() ?: return@async null

                            PokemonList(
                                id = pokemon.id.toString(),
                                name = item.name,
                                sprite = pokemon.sprites.other.officialArtwork.frontDefault,
                                types = pokemon.types.map {
                                    it.type.name
                                }
                            )
                        } catch (exception: Exception) {
                            Log.e(
                                "POKEDEXVIEWMODEL",
                                "Error fetching ${item.name}: ${exception.message}"
                            )
                            null
                        }
                    }
                }.awaitAll().filterNotNull()
                _state.value = PokedexState.Success(pokemonList)
            }.onFailure {
                _state.value = PokedexState.Error(
                    ExceptionHandler.parse(it)
                )
            }
        }
    }
}

sealed class PokedexState {
    object Loading : PokedexState()
    data class Success(val data: List<PokemonList>) : PokedexState()
    data class Error(val message: String) : PokedexState()
}