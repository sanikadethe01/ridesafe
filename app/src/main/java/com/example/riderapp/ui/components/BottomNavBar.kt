package com.example.riderapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.riderapp.navigation.Screen

sealed class BottomNavItem(

    val title: String,

    val icon: ImageVector,

    val route: String

) {

    object Home : BottomNavItem(
        "Home",
        Icons.Default.Home,
        Screen.Dashboard.route
    )

    object History : BottomNavItem(
        "History",
        Icons.Default.History,
        Screen.History.route
    )

    object Contacts : BottomNavItem(
        "Contacts",
        Icons.Default.Group,
        Screen.Contacts.route
    )

    object Profile : BottomNavItem(
        "Profile",
        Icons.Default.Person,
        Screen.Profile.route
    )
}