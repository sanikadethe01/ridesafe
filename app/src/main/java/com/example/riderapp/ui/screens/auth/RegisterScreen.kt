package com.example.riderapp.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.ui.components.CustomTextField
import com.example.riderapp.ui.components.PurpleButton

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    var localError by remember {
        mutableStateOf("")
    }

    if (viewModel.state.isSuccess) {
        LaunchedEffect(Unit) {
            navController.popBackStack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        CustomTextField(
            name,
            { name = it },
            "Name"
        )

        CustomTextField(
            email,
            { email = it },
            "Email"
        )

        CustomTextField(
            phone,
            { phone = it },
            "Phone"
        )

        CustomTextField(
            password,
            { password = it },
            "Password"
        )

        CustomTextField(
            confirm,
            { confirm = it },
            "Confirm Password"
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        PurpleButton(
            text = "REGISTER"
        ) {

            if (password != confirm) {
                localError = "Passwords do not match"
                return@PurpleButton
            }

            viewModel.register(
                name,
                email,
                phone,
                password
            )
        }

        if (localError.isNotEmpty()) {
            Text(localError)
        }

        if (viewModel.state.error.isNotEmpty()) {
            Text(viewModel.state.error)
        }
    }
}