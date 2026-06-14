package com.example.riderapp.ui.screens.activeride

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class ActiveRideViewModel : ViewModel() {

    var currentLocation by mutableStateOf("Karad")

    var eta by mutableStateOf("7:30 PM")

    var smsSent by mutableStateOf(0)
}