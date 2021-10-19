package com.hamsterdev.subscriber.presentation.main.activeSubscriptions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamsterdev.subscriber.common.ApiResult
import com.hamsterdev.subscriber.domain.useCase.getAvailableSuscriptions.GetAvailableSubsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ActiveSubsViewModel @Inject constructor(
    private val subsUseCase: GetAvailableSubsUseCase
) : ViewModel() {
    private val _state = mutableStateOf<ActiveSubsState>(ActiveSubsState())
    val state: State<ActiveSubsState> = _state

    init {
        getSubs()
    }
    private fun getSubs() {
        subsUseCase().onEach { result ->
            when (result) {
                is ApiResult.Loading -> {
                    _state.value = ActiveSubsState(true)
                }
                is ApiResult.Error -> {
                    _state.value = ActiveSubsState(false, emptyList(), result.message)

                }
                is ApiResult.Success -> {
                    _state.value = ActiveSubsState(false, result.subsList)
                }
            }
        }.launchIn(viewModelScope)
    }
}