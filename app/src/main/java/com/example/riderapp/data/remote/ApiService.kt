package com.example.riderapp.data.remote

import com.example.riderapp.data.model.Contact
import com.example.riderapp.data.model.ContactRequest
import com.example.riderapp.data.model.ContactResponse
import com.example.riderapp.data.model.ContactListResponse
import com.example.riderapp.data.model.DeleteResponse
import com.example.riderapp.data.model.Location
import com.example.riderapp.data.model.LocationRequest
import com.example.riderapp.data.model.LoginRequest
import com.example.riderapp.data.model.LoginResponse
import com.example.riderapp.data.model.RegisterRequest
import com.example.riderapp.data.model.RegisterResponse
import com.example.riderapp.data.model.Ride
import com.example.riderapp.data.model.RideRequest
import retrofit2.http.*

interface ApiService {

    // ---------------- Authentication ----------------

    @POST("api/auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("api/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    // ---------------- Contacts ----------------

    @POST("api/contacts/add")
    suspend fun addContact(
        @Header("Authorization")
        token: String,
        @Body request: ContactRequest
    ): ContactResponse

    @GET("api/contacts")
    suspend fun getContacts(
        @Header("Authorization")
        token: String
    ): ContactListResponse

    @DELETE("api/contacts/{id}")
    suspend fun deleteContact(
        @Header("Authorization")
        token: String,
        @Path("id")
        id: String
    ): DeleteResponse

    // ---------------- Ride ----------------

    @POST("api/rides/create")
    suspend fun createRide(
        @Body request: RideRequest
    ): Ride

    @POST("api/location/update")
    suspend fun updateLocation(
        @Body request: LocationRequest
    ): Location
}