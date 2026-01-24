package com.app.connect.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {

    protected val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    protected fun showLoading() {
        _loading.value = true
    }

    protected fun hideLoading() {
        _loading.value = false
    }

    protected fun handleError(e: Exception): UiState.Error {
        return UiState.Error(e.message ?: "Something went wrong")
    }
}
