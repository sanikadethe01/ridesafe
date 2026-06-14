package com.example.riderapp.utils

object ETAUtils {

    fun calculateETA(
        distanceKm: Double,
        speedKmHr: Double
    ): Double {

        return distanceKm / speedKmHr
    }
}