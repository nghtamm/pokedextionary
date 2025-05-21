package com.nghtamm.pokedextionary.features.onboarding.presentation

import androidx.lifecycle.*
import com.nghtamm.pokedextionary.features.onboarding.data.repository.OnboardingRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val repository: OnboardingRepository
) : ViewModel() {
    private val _isCompleted = MutableStateFlow<Boolean>(false)
    val isCompleted: StateFlow<Boolean> = _isCompleted

    init {
        viewModelScope.launch {
            _isCompleted.value = repository.isCompleted()
        }
    }

    fun complete() {
        viewModelScope.launch {
            repository.complete()
            _isCompleted.value = true
        }
    }
}