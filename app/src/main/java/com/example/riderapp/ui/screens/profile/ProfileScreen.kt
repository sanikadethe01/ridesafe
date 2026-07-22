package com.example.riderapp.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.BottomBar
import com.example.riderapp.utils.SessionManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {

    val name = SessionManager.name
    val email = SessionManager.email
    val phone = SessionManager.phone

    Scaffold(

        containerColor = Color(0xFFF6F4FF),

        topBar = {
            TopAppBar(
                title = {
                    Text("Profile")
                }
            )
        },

        bottomBar = {
            BottomBar(navController)
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFEDE7FF)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(20.dp)
                                .size(60.dp),
                            tint = Color(0xFF6C63FF)
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            ListItem(
                headlineContent = {
                    Text(email)
                },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                }
            )

            HorizontalDivider()

            ListItem(
                headlineContent = {
                    Text(phone)
                },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(

                onClick = {

                    SessionManager.token = ""
                    SessionManager.userId = ""
                    SessionManager.name = ""
                    SessionManager.email = ""
                    SessionManager.phone = ""

                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }

                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Logout")

            }

            Spacer(modifier = Modifier.height(80.dp))

        }

    }

}