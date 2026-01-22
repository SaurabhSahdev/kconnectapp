package com.practice.jetpackpractice.presentation.registration

import androidx.lifecycle.viewModelScope
import com.practice.jetpackpractice.domain.model.User
import com.practice.jetpackpractice.domain.usecase.RegisterUseCase
import com.practice.jetpackpractice.presentation.base.BaseViewModel
import com.practice.jetpackpractice.presentation.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<User>>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun register(email: String, password: String) {
        viewModelScope.launch {
            try {
                showLoading()
                _uiState.value = UiState.Loading

                val user = registerUseCase(email, password)

                _uiState.value = UiState.Success(user)
            } catch (e: Exception) {
                _uiState.value = handleError(e)
            } finally {
                hideLoading()
            }
        }
    }
}

