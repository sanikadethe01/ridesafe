package com.example.riderapp.data.repository

import android.util.Log
import com.example.riderapp.data.model.ContactRequest
import com.example.riderapp.data.remote.RetrofitClient
import com.example.riderapp.utils.SessionManager
import retrofit2.HttpException

class ContactRepository {

    suspend fun addContact(
        name: String,
        relation: String,
        phone: String
    ) {

        Log.d("CONTACT", "TOKEN = ${SessionManager.token}")
        Log.d("CONTACT", "USER ID = ${SessionManager.userId}")

        try {

            val response = RetrofitClient.api.addContact(
                "Bearer ${SessionManager.token}",
                ContactRequest(
                    name = name,
                    relation = relation,
                    phone = phone,
                    userId = SessionManager.userId
                )
            )

            Log.d("CONTACT", response.toString())

        } catch (e: HttpException) {

            Log.e(
                "CONTACT",
                "HTTP ${e.code()} : ${e.response()?.errorBody()?.string()}"
            )

            throw Exception("HTTP ${e.code()}")

        } catch (e: Exception) {

            Log.e("CONTACT", e.toString())

            throw e
        }
    }
}