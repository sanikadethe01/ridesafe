package com.example.riderapp.ui.screens.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.BottomBar
import com.example.riderapp.ui.components.PurpleButton

data class EmergencyContact(
    val name: String = "",
    val relationship: String = "",
    val phone: String = ""
)

@Composable
fun ContactScreen(
    navController: NavController
) {

    val vm: ContactViewModel = viewModel()

    val contacts = remember {
        mutableStateListOf(
            EmergencyContact()
        )
    }

    Scaffold(
        containerColor = Color(0xFFF6F4FF),
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Emergency Contacts",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Your trusted contacts will receive ride updates if enabled.",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                itemsIndexed(contacts) { index, contact ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = "Contact ${index + 1}",
                                    fontWeight = FontWeight.Bold
                                )

                                if (contacts.size > 1) {
                                    IconButton(
                                        onClick = {
                                            contacts.removeAt(index)
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Contact",
                                            tint = Color.Red
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = contact.name,
                                onValueChange = {
                                    contacts[index] = contact.copy(name = it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text("Full Name")
                                },
                                leadingIcon = {
                                    Icon(Icons.Default.Person, null)
                                },
                                shape = RoundedCornerShape(14.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            OutlinedTextField(
                                value = contact.relationship,
                                onValueChange = {
                                    contacts[index] =
                                        contact.copy(relationship = it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text("Relationship")
                                },
                                shape = RoundedCornerShape(14.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            OutlinedTextField(
                                value = contact.phone,
                                onValueChange = {
                                    contacts[index] =
                                        contact.copy(phone = it)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text("Phone Number")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Phone
                                ),
                                shape = RoundedCornerShape(14.dp)
                            )
                        }
                    }
                }

                item {

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            contacts.add(EmergencyContact())
                        }
                    ) {

                        Icon(
                            Icons.Default.Add,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text("Add Another Contact")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    PurpleButton(
                        text = "CONTINUE"
                    ) {

                        val validContacts = contacts.filter {

                            it.name.isNotBlank() &&
                                    it.relationship.isNotBlank() &&
                                    it.phone.isNotBlank()

                        }

                        if (validContacts.isEmpty()) {
                            return@PurpleButton
                        }

                        vm.saveContacts(
                            contacts = validContacts,
                            success = {
                                navController.navigate(Screen.ActiveRide.route)
                            },
                            failure = {
                                println(it)
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}