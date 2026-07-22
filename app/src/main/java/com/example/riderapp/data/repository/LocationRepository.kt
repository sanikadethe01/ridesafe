package com.example.riderapp.data.repository

import com.example.riderapp.data.model.LocationRequest
import com.example.riderapp.data.remote.RetrofitClient

class LocationRepository {

    suspend fun updateLocation(
        rideId:String,
        lat:Double,
        lng:Double
    )=
        RetrofitClient.api.updateLocation(
            LocationRequest(
                rideId,
                lat,
                lng
            )
        )
}