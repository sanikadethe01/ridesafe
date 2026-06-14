package com.example.riderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.riderapp.navigation.AppNavGraph
import com.example.riderapp.ui.theme.RiderAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RiderAppTheme {
                AppNavGraph()
            }
        }
    }
}