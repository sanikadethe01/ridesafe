package com.example.riderapp.ui.screens.activeride

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun ActiveRideScreen(
    onEndRide: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            "Ride In Progress",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Destination : Pune Home")
        Text("ETA : 7:30 PM")
        Text("SMS Sent : 4")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onEndRide,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("End Ride")
        }
    }
}