package com.example.riderapp.ui.screens.contacts

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    var name by mutableStateOf("")
    var relation by mutableStateOf("")
    var phone by mutableStateOf("")

}