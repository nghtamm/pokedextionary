package com.nghtamm.pokedextionary.features.pokedex.presentation

import androidx.lifecycle.*
import com.nghtamm.pokedextionary.core.network.ExceptionHandler
import com.nghtamm.pokedextionary.features.pokedex.data.models.PokemonListResponse
import com.nghtamm.pokedextionary.features.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

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
                _state.value = PokedexState.Success(it)
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
    data class Success(val data: PokemonListResponse) : PokedexState()
    data class Error(val message: String) : PokedexState()
}