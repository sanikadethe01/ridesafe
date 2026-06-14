package com.example.riderapp.ui.screens.ridesetup

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class RideSetupViewModel : ViewModel() {

    var destination by mutableStateOf("")

    var eta by mutableStateOf("")

    var smsInterval by mutableStateOf(30)

}