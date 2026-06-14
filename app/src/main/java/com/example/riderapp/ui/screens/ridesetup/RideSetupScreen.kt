package com.example.riderapp.ui.screens.ridesetup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp

@Composable
fun RideSetupScreen(
    onStartRide: () -> Unit
) {

    var destination by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            "Start Ride",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destination") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onStartRide,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Ride")
        }
    }
}