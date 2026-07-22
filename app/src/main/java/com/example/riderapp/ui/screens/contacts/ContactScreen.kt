//package com.example.riderapp.ui.screens.contacts
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.riderapp.ui.components.BottomBar
//import com.example.riderapp.ui.components.PurpleButton
//
//@Composable
//fun ContactScreen(
//    navController: NavController
//) {
//
//    val vm: ContactViewModel = viewModel()
//
//    val contacts by vm.contacts.collectAsState()
//
//    var name by remember { mutableStateOf("") }
//    var relation by remember { mutableStateOf("") }
//    var phone by remember { mutableStateOf("") }
//
//    LaunchedEffect(Unit) {
//        vm.loadContacts()
//    }
//
//    Scaffold(
//        containerColor = Color(0xFFF6F4FF),
//        bottomBar = {
//            BottomBar(navController)
//        }
//    ) { padding ->
//
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFFF6F4FF))
//                .padding(padding)
//                .padding(horizontal = 20.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//
//            item {
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                Text(
//                    text = "Emergency Contacts",
//                    style = MaterialTheme.typography.headlineMedium,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(6.dp))
//
//                Text(
//                    text = "Your trusted contacts will receive ride updates.",
//                    color = Color.Gray
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Text(
//                    text = "Saved Contacts",
//                    style = MaterialTheme.typography.titleLarge,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(12.dp))
//            }
//
//            items(contacts) { contact ->
//
//                Card(
//                    modifier = Modifier.fillMaxWidth(),
//                    shape = RoundedCornerShape(16.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color.White
//                    )
//                ) {
//
//                    Column(
//                        modifier = Modifier.padding(16.dp)
//                    ) {
//
//                        Text(
//                            text = contact.name,
//                            style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                        Spacer(modifier = Modifier.height(4.dp))
//
//                        Text(
//                            text = contact.relation,
//                            color = Color.Gray
//                        )
//
//                        Spacer(modifier = Modifier.height(4.dp))
//
//                        Text(
//                            text = contact.phone
//                        )
//
//                        Spacer(modifier = Modifier.height(10.dp))
//
//                        TextButton(
//                            onClick = {
//                                vm.deleteContact(contact._id)
//                            }
//                        ) {
//                            Text(
//                                text = "Delete",
//                                color = Color.Red
//                            )
//                        }
//
//                    }
//
//                }
//
//            }
//
//            item {
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Text(
//                    text = "Add New Contact",
//                    style = MaterialTheme.typography.titleLarge,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                OutlinedTextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text("Full Name")
//                    },
//                    shape = RoundedCornerShape(14.dp)
//                )
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                OutlinedTextField(
//                    value = relation,
//                    onValueChange = { relation = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text("Relationship")
//                    },
//                    shape = RoundedCornerShape(14.dp)
//                )
//
//                Spacer(modifier = Modifier.height(12.dp))
//
//                OutlinedTextField(
//                    value = phone,
//                    onValueChange = { phone = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text("Phone Number")
//                    },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Phone
//                    ),
//                    shape = RoundedCornerShape(14.dp)
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                PurpleButton(
//                    text = "SAVE CONTACT"
//                ) {
//
//                    if (
//                        name.isBlank() ||
//                        relation.isBlank() ||
//                        phone.isBlank()
//                    ) {
//                        return@PurpleButton
//                    }
//
//                    vm.addContact(
//                        name = name,
//                        relation = relation,
//                        phone = phone,
//                        success = {
//
//                            name = ""
//                            relation = ""
//                            phone = ""
//
//                        },
//                        failure = {
//
//                            println(it)
//
//                        }
//                    )
//
//                }
//
//                Spacer(modifier = Modifier.height(30.dp))
//
//            }
//
//        }
//
//    }
//
//}
package com.example.riderapp.ui.screens.contacts

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.riderapp.ui.components.BottomBar
import com.example.riderapp.ui.components.PurpleButton

@Composable
fun ContactScreen(
    navController: NavController
) {

    val vm: ContactViewModel = viewModel()

    val context = LocalContext.current

    val contacts by vm.contacts.collectAsState()

    var name by remember { mutableStateOf("") }
    var relation by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.loadContacts()
    }

    Scaffold(
        containerColor = Color(0xFFF6F4FF),
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F4FF))
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Emergency Contacts",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Your trusted contacts will receive ride updates.",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Saved Contacts",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            if (contacts.isEmpty()) {

                item {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {

                        Text(
                            text = "No contacts added yet.",
                            modifier = Modifier.padding(20.dp),
                            color = Color.Gray
                        )

                    }

                }

            }

            items(contacts) { contact ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = contact.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = contact.relation,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = contact.phone
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        TextButton(
                            onClick = {

                                vm.deleteContact(

                                    id = contact._id,

                                    success = {

                                        Toast.makeText(
                                            context,
                                            "Contact Deleted",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                    },

                                    failure = {

                                        Toast.makeText(
                                            context,
                                            it,
                                            Toast.LENGTH_SHORT
                                        ).show()

                                    }

                                )

                            }
                        ) {

                            Text(
                                text = "Delete",
                                color = Color.Red
                            )

                        }

                    }

                }

            }

            item {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Add New Contact",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Full Name")
                    },
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = relation,
                    onValueChange = {
                        relation = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Relationship")
                    },
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
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

                Spacer(modifier = Modifier.height(20.dp))

                PurpleButton(
                    text = "SAVE CONTACT"
                ) {

                    if (
                        name.isBlank() ||
                        relation.isBlank() ||
                        phone.isBlank()
                    ) {

                        Toast.makeText(
                            context,
                            "Please fill all fields",
                            Toast.LENGTH_SHORT
                        ).show()

                        return@PurpleButton
                    }

                    vm.addContact(

                        name = name,

                        relation = relation,

                        phone = phone,

                        success = {

                            Toast.makeText(
                                context,
                                "Contact Added Successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                            name = ""
                            relation = ""
                            phone = ""

                            vm.loadContacts()

                        },

                        failure = {

                            Toast.makeText(
                                context,
                                it,
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    )

                }

                Spacer(modifier = Modifier.height(30.dp))

            }

        }

    }

}