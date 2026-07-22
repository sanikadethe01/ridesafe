package com.example.riderapp.navigation

sealed class Screen(

    val route: String

) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Dashboard : Screen("dashboard")
    object Contacts : Screen("contacts")
    object ActiveRide : Screen("active_ride")
    object RideCompleted:Screen("ride_completed")
    object History : Screen("history")
    object Profile : Screen("profile")
}