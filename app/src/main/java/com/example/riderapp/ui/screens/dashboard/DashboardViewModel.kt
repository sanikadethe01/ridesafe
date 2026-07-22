package com.example.riderapp.ui.screens.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    var state by mutableStateOf(
        DashboardUiState()
    )
        private set

    fun setName(
        name: String
    ) {
        state = state.copy(
            userName = name
        )
    }

    fun setDestination(
        destination: String
    ) {
        state = state.copy(
            destination = destination
        )
    }

    fun setEta(
        eta: Int
    ) {
        state = state.copy(
            eta = eta
        )
    }

    fun startRide(
        destination: String,
        eta: Int,
        success: () -> Unit,
        failure: (String) -> Unit
    ) {

        if (destination.isBlank()) {
            failure("Please enter destination")
            return
        }

        state = state.copy(
            destination = destination,
            eta = eta
        )

        success()
    }
}