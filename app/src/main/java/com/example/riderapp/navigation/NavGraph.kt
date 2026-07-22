package com.example.riderapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.riderapp.ui.screens.auth.*
import com.example.riderapp.ui.screens.contacts.ContactScreen
import com.example.riderapp.ui.screens.dashboard.DashboardScreen
import com.example.riderapp.ui.screens.activeride.ActiveRideScreen
import com.example.riderapp.ui.screens.history.HistoryScreen
import com.example.riderapp.ui.screens.profile.ProfileScreen
import com.example.riderapp.ui.screens.ridecompleted.RideCompletedScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                navController,
                authViewModel
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                navController,
                authViewModel
            )
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                navController
            )
        }
        composable(Screen.Contacts.route) {
            ContactScreen(
                navController
            )
        }
        composable(Screen.ActiveRide.route) {
            ActiveRideScreen(
                navController
            )
        }
        composable(Screen.RideCompleted.route) {
            RideCompletedScreen(navController)
        }
        composable(Screen.History.route) {
            HistoryScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}