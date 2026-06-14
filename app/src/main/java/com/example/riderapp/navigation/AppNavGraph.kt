package com.example.riderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.riderapp.ui.screens.login.LoginScreen
import com.example.riderapp.ui.screens.contacts.ContactScreen
import com.example.riderapp.ui.screens.ridesetup.RideSetupScreen
import com.example.riderapp.ui.screens.activeride.ActiveRideScreen
import com.example.riderapp.ui.screens.completedride.RideCompletedScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        composable(Screen.Login.route) {
            LoginScreen {
                navController.navigate(Screen.Contacts.route)
            }
        }

        composable(Screen.Contacts.route) {
            ContactScreen {
                navController.navigate(Screen.RideSetup.route)
            }
        }

        composable(Screen.RideSetup.route) {
            RideSetupScreen {
                navController.navigate(Screen.ActiveRide.route)
            }
        }

        composable(Screen.ActiveRide.route) {
            ActiveRideScreen {
                navController.navigate(Screen.RideCompleted.route)
            }
        }

        composable(Screen.RideCompleted.route) {
            RideCompletedScreen()
        }
    }
}