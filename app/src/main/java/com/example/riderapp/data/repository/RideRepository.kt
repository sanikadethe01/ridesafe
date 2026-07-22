package com.example.riderapp.data.repository

import com.example.riderapp.data.model.RideRequest
import com.example.riderapp.data.remote.RetrofitClient

class RideRepository {
    suspend fun createRide(
        destination: String,
        eta: Int
    ) =
        RetrofitClient.api.createRide(
            RideRequest(
                destination,
                eta
            )
        )
}