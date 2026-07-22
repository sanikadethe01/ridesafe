package com.example.riderapp.ui.screens.ridecompleted

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.PurpleButton

@Composable
fun RideCompletedScreen(

    navController: NavController

){

    Column(

        modifier=Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment=Alignment.CenterHorizontally,

        verticalArrangement=Arrangement.Center

    ){

        Icon(

            Icons.Default.CheckCircle,

            contentDescription=null,

            tint= Color.Green,

            modifier=Modifier.size(120.dp)

        )

        Spacer(
            modifier=Modifier.height(20.dp)
        )

        Text(

            "Ride Completed",

            style=MaterialTheme.typography.headlineMedium,

            fontWeight=FontWeight.Bold

        )

        Spacer(
            modifier=Modifier.height(10.dp)
        )

        Text(

            "You reached safely."

        )

        Spacer(
            modifier=Modifier.height(40.dp)
        )

        PurpleButton(

            text="Back To Home"

        ){

            navController.navigate(

                Screen.Dashboard.route

            ){

                popUpTo(Screen.Dashboard.route){

                    inclusive=true

                }

            }

        }

    }

}