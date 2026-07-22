package com.example.riderapp.data.repository

import com.example.riderapp.data.model.LoginRequest
import com.example.riderapp.data.model.RegisterRequest
import com.example.riderapp.data.remote.RetrofitClient
import com.example.riderapp.utils.SessionManager

class AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ) = RetrofitClient.api.login(
        LoginRequest(
            email = email,
            password = password
        )
    ).also { response ->

        // Save login session
        SessionManager.token = response.token
        SessionManager.userId = response.user.id
        SessionManager.name = response.user.name
        SessionManager.email = response.user.email
        SessionManager.phone = response.user.phone
    }

    suspend fun register(
        name: String,
        email: String,
        phone: String,
        password: String
    ) = RetrofitClient.api.register(
        RegisterRequest(
            name = name,
            email = email,
            phone = phone,
            password = password
        )
    )
}