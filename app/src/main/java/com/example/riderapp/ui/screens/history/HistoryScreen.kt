package com.example.riderapp.ui.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.ui.components.BottomBar

data class RideHistory(
    val destination: String,
    val date: String,
    val duration: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavController
) {

    val rides = listOf(
        RideHistory(
            destination = "PCCOE Pune",
            date = "10 Jun 2026",
            duration = "45 mins"
        ),
        RideHistory(
            destination = "Home",
            date = "08 Jun 2026",
            duration = "1 hr 20 mins"
        ),
        RideHistory(
            destination = "Office",
            date = "05 Jun 2026",
            duration = "35 mins"
        )
    )

    Scaffold(

        containerColor = Color(0xFFF6F4FF),

        topBar = {

            TopAppBar(

                title = {

                    Text("Ride History")

                }

            )

        },

        bottomBar = {

            BottomBar(navController)

        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(paddingValues)
                .padding(horizontal = 16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp),

            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = 90.dp
            )

        ) {

            items(rides) { ride ->

                Card(

                    modifier = Modifier.fillMaxWidth(),

                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )

                ) {

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        Column {

                            Text(

                                text = ride.destination,

                                style = MaterialTheme.typography.titleMedium,

                                fontWeight = FontWeight.Bold

                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(

                                text = ride.date,

                                style = MaterialTheme.typography.bodyMedium

                            )

                        }

                        Column {

                            Icon(

                                imageVector = Icons.Default.History,

                                contentDescription = null

                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(

                                text = ride.duration,

                                style = MaterialTheme.typography.bodyMedium

                            )

                        }

                    }

                }

            }

        }

    }

}