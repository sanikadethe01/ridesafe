package com.example.riderapp.data.model

data class LoginResponse(
    val message: String,
    val token: String,
    val user: UserResponse
)