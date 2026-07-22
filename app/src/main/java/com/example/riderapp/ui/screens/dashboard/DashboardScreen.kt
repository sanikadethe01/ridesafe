package com.example.riderapp.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.R
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.PurpleButton
import com.example.riderapp.ui.components.BottomBar

@Composable
fun DashboardScreen(
    navController: NavController
) {

    var destination by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf(30) }

    Scaffold(

        containerColor = Color(0xFFF6F4FF),

        bottomBar = {

            BottomBar(navController)

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(padding)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())

        ) {

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = CircleShape,
                    color = Color.White
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                }

                Surface(
                    shape = CircleShape,
                    color = Color.White
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = null)
                    }
                }

            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Good Evening,",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Sanika 👋",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEDE7FF)
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.bike),
                        contentDescription = "Bike",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Ready to Ride?",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Stay connected with your loved ones throughout your journey.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Destination",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = destination,
                onValueChange = { destination = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color(0xFF6C63FF)
                    )
                },
                placeholder = {
                    Text("Enter destination")
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Expected Arrival",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = arrival,
                onValueChange = { arrival = it },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        Icons.Default.Schedule,
                        contentDescription = null,
                        tint = Color(0xFF6C63FF)
                    )
                },
                placeholder = {
                    Text("Example: 7:30 PM")
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Update Frequency",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                FilterChip(
                    selected = frequency == 15,
                    onClick = { frequency = 15 },
                    label = { Text("15 Min") }
                )

                FilterChip(
                    selected = frequency == 30,
                    onClick = { frequency = 30 },
                    label = { Text("30 Min") }
                )

                FilterChip(
                    selected = frequency == 60,
                    onClick = { frequency = 60 },
                    label = { Text("60 Min") }
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            PurpleButton(

                text = "START RIDE"

            ) {

                if (destination.isBlank()) return@PurpleButton

                if (arrival.isBlank()) return@PurpleButton

                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("destination", destination)

                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("arrival", arrival)

                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("frequency", frequency)

                navController.navigate(Screen.ActiveRide.route)

            }

            }

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        color = Color(0xFFE9E2FF),
                        shape = CircleShape
                    ) {

                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.padding(12.dp),
                            tint = Color(0xFF6C63FF)
                        )

                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {

                        Text(
                            text = "RideSafe Protection",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Your emergency contacts will automatically receive your live location during the ride.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }