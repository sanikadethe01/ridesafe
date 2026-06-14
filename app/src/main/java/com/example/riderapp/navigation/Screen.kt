package com.example.riderapp.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")

    object Contacts : Screen("contacts")

    object RideSetup : Screen("ride_setup")

    object ActiveRide : Screen("active_ride")

    object RideCompleted : Screen("ride_completed")
}