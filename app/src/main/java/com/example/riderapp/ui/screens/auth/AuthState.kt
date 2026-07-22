package com.example.riderapp.ui.screens.auth

data class AuthState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String = ""
)