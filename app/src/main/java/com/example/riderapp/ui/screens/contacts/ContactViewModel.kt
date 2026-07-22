package com.example.riderapp.ui.screens.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riderapp.data.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val repository = ContactRepository()

    fun saveContacts(
        contacts: List<EmergencyContact>,
        success: () -> Unit,
        failure: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                contacts.forEach { contact ->
                    repository.addContact(
                        contact.name,
                        contact.relationship,
                        contact.phone
                    )
                }
                success()
            }
            catch (e: Exception) {
                failure(
                    e.message ?: "Unable to save contacts"
                )
            }
        }
    }
}