package com.practice.jetpackpractice.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.jetpackpractice.domain.model.User
import com.practice.jetpackpractice.domain.usecase.LoginUseCase
import com.practice.jetpackpractice.presentation.base.BaseViewModel
import com.practice.jetpackpractice.presentation.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<User>>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                showLoading()
                _uiState.value = UiState.Loading

                val user = loginUseCase(email, password)

                _uiState.value = UiState.Success(user)
            } catch (e: Exception) {
                _uiState.value = handleError(e)
            } finally {
                hideLoading()
            }
        }
    }
}

