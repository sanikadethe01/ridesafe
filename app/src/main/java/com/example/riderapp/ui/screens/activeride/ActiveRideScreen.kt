package com.example.riderapp.ui.screens.activeride

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.PurpleButton
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ActiveRideScreen(
    navController: NavController
) {

    val vm: ActiveRideViewModel = viewModel()

    val destination = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<String>("destination") ?: "Unknown"

    val arrival = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<String>("arrival") ?: "--"

    val frequency = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<Int>("frequency") ?: 30

    Scaffold(

        containerColor = Color(0xFFF6F4FF)

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Text(

                text = "Ride In Progress",

                style = MaterialTheme.typography.headlineMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(25.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Row {

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            "Destination",
                            fontWeight = FontWeight.Bold
                        )

                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(destination)

                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Row {

                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            "Expected Arrival",
                            fontWeight = FontWeight.Bold
                        )

                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(arrival)

                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        "Location Update Frequency",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Every $frequency minutes")

                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        "Ride Status",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Ride Active")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Updates Sent : ${vm.updates}")

                }

            }

            Spacer(modifier = Modifier.height(30.dp))

            PurpleButton(

                text = "END RIDE"

            ) {

                navController.navigate(Screen.RideCompleted.route)

            }

        }

    }

}