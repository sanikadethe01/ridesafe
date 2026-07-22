package com.example.riderapp.ui.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riderapp.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()

    var state by mutableStateOf(AuthState())
        private set

    fun login(
        email: String,
        password: String
    ) {

        state = state.copy(
            isLoading = true,
            error = ""
        )

        viewModelScope.launch {

            try {

                repository.login(
                    email,
                    password
                )

                state = state.copy(
                    isLoading = false,
                    isSuccess = true
                )

            } catch (e: Exception) {

                state = state.copy(
                    isLoading = false,
                    error = e.message ?: "Login Failed"
                )

            }

        }
    }

    fun register(
        name: String,
        email: String,
        phone: String,
        password: String
    ) {

        state = state.copy(
            isLoading = true,
            error = ""
        )

        viewModelScope.launch {

            try {

                repository.register(
                    name,
                    email,
                    phone,
                    password
                )

                state = state.copy(
                    isLoading = false,
                    isSuccess = true
                )

            } catch (e: Exception) {

                state = state.copy(
                    isLoading = false,
                    error = e.message ?: "Registration Failed"
                )

            }

        }
    }
}