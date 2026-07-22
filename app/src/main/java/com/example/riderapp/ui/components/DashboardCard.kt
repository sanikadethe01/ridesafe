package com.example.riderapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardCard(

    title:String,

    content:String

){

    Card(

        shape=RoundedCornerShape(18.dp),

        modifier=Modifier.fillMaxWidth()

    ){

        Column(

            modifier=Modifier.padding(16.dp)

        ){

            Text(

                title,

                style=MaterialTheme.typography.titleMedium

            )

            Spacer(
                Modifier.height(8.dp)
            )

            Text(content)

        }

    }

}