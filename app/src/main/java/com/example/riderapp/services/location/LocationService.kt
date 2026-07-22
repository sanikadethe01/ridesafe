package com.example.riderapp.services.location

import android.content.Context
import com.google.android.gms.location.*

class LocationService(
    private val context: Context
) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)
}