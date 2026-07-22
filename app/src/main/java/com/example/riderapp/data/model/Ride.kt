package com.example.riderapp.data.model

data class Ride(
    val _id: String? = null,
    val destination: String,
    val expectedArrival: Int,
    val status: String
)