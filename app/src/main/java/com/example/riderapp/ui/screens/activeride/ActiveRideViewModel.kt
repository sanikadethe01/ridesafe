package com.example.riderapp.ui.screens.activeride

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ActiveRideViewModel : ViewModel() {

    var updates by mutableIntStateOf(0)
        private set

    fun increase() {
        updates++
    }

    fun reset() {
        updates = 0
    }
}