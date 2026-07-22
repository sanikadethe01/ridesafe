//package com.example.riderapp.data.repository
//
//import com.example.riderapp.data.model.Contact
//import com.example.riderapp.data.model.ContactRequest
//import com.example.riderapp.data.remote.RetrofitClient
//import com.example.riderapp.utils.SessionManager
//
//class ContactRepository {
//
//    suspend fun getContacts(): List<Contact> {
//
//        val response = RetrofitClient.api.getContacts(
//            "Bearer ${SessionManager.token}"
//        )
//
//        return response.contacts
//    }
//
//    suspend fun addContact(
//        name: String,
//        relation: String,
//        phone: String
//    ) {
//
//        RetrofitClient.api.addContact(
//            "Bearer ${SessionManager.token}",
//            ContactRequest(
//                name = name,
//                relation = relation,
//                phone = phone
//            )
//        )
//    }
//
//    suspend fun deleteContact(
//        id: String
//    ) {
//
//        RetrofitClient.api.deleteContact(
//            "Bearer ${SessionManager.token}",
//            id
//        )
//    }
//}
package com.example.riderapp.data.repository

import com.example.riderapp.data.model.Contact
import com.example.riderapp.data.model.ContactRequest
import com.example.riderapp.data.remote.RetrofitClient
import com.example.riderapp.utils.SessionManager
import retrofit2.HttpException

class ContactRepository {

    suspend fun getContacts(): List<Contact> {

        return try {

            val response = RetrofitClient.api.getContacts(
                "Bearer ${SessionManager.token}"
            )

            response.contacts

        } catch (e: Exception) {
            emptyList()
        }

    }

    suspend fun addContact(
        name: String,
        relation: String,
        phone: String
    ) {

        try {

            RetrofitClient.api.addContact(
                "Bearer ${SessionManager.token}",
                ContactRequest(
                    name = name,
                    relation = relation,
                    phone = phone
                )
            )

        } catch (e: HttpException) {

            val error = e.response()?.errorBody()?.string()

            if (error?.contains("already exists") == true) {
                throw Exception("Contact already exists.")
            }

            throw Exception("Unable to add contact.")

        } catch (e: Exception) {

            throw Exception(e.message ?: "Something went wrong")

        }

    }

    suspend fun deleteContact(
        id: String
    ) {

        try {

            RetrofitClient.api.deleteContact(
                "Bearer ${SessionManager.token}",
                id
            )

        } catch (e: Exception) {

            throw Exception("Unable to delete contact")

        }

    }

}