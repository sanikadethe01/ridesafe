package com.example.riderapp.data.model

data class Ride(
    val rideId: String = "",
    val destination: String = "",
    val startTime: Long = 0L,
    val eta: String = "",
    val status: String = ""
)