package com.example.riderapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(

    navController: NavController

) {

    val items = listOf(

        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Contacts,
        BottomNavItem.Profile
    )
    NavigationBar {
        val navBackStackEntry =
            navController.currentBackStackEntryAsState()

        val currentRoute =
            navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(item.icon, null)
                },
                label = {
                    Text(item.title)
                }
            )
        }
    }
}