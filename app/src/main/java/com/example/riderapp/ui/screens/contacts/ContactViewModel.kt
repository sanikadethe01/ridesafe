//package com.example.riderapp.ui.screens.contacts
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.riderapp.data.model.Contact
//import com.example.riderapp.data.repository.ContactRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class ContactViewModel : ViewModel() {
//
//    private val repository = ContactRepository()
//
//    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
//    val contacts: StateFlow<List<Contact>> = _contacts
//
//    private val _loading = MutableStateFlow(false)
//    val loading: StateFlow<Boolean> = _loading
//
//    fun loadContacts() {
//
//        viewModelScope.launch {
//
//            _loading.value = true
//
//            try {
//
//                _contacts.value = repository.getContacts()
//
//            } catch (e: Exception) {
//
//                e.printStackTrace()
//
//            } finally {
//
//                _loading.value = false
//
//            }
//
//        }
//
//    }
//
//    fun addContact(
//
//        name: String,
//
//        relation: String,
//
//        phone: String,
//
//        success: () -> Unit,
//
//        failure: (String) -> Unit
//
//    ) {
//
//        viewModelScope.launch {
//
//            try {
//
//                repository.addContact(
//                    name,
//                    relation,
//                    phone
//                )
//
//                loadContacts()
//
//                success()
//
//            } catch (e: Exception) {
//
//                failure(
//                    e.message ?: "Unable to add contact"
//                )
//
//            }
//
//        }
//
//    }
//
//    fun deleteContact(
//
//        id: String
//
//    ) {
//
//        viewModelScope.launch {
//
//            try {
//
//                repository.deleteContact(id)
//
//                loadContacts()
//
//            } catch (e: Exception) {
//
//                e.printStackTrace()
//
//            }
//
//        }
//
//    }
//
//}
package com.example.riderapp.ui.screens.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riderapp.data.model.Contact
import com.example.riderapp.data.repository.ContactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val repository = ContactRepository()

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun loadContacts() {

        viewModelScope.launch {

            _loading.value = true

            try {

                _contacts.value = repository.getContacts()

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                _loading.value = false

            }

        }

    }

    fun addContact(
        name: String,
        relation: String,
        phone: String,
        success: () -> Unit,
        failure: (String) -> Unit
    ) {

        viewModelScope.launch {

            try {

                repository.addContact(
                    name = name,
                    relation = relation,
                    phone = phone
                )

                loadContacts()

                success()

            } catch (e: Exception) {

                failure(
                    e.message ?: "Unable to add contact"
                )

            }

        }

    }

    fun deleteContact(
        id: String,
        success: () -> Unit = {},
        failure: (String) -> Unit = {}
    ) {

        viewModelScope.launch {

            try {

                repository.deleteContact(id)

                loadContacts()

                success()

            } catch (e: Exception) {

                failure(
                    e.message ?: "Unable to delete contact"
                )

            }

        }

    }

}