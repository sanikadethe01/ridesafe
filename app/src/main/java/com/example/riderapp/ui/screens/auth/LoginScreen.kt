package com.example.riderapp.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riderapp.navigation.Screen
import com.example.riderapp.ui.components.CustomTextField
import com.example.riderapp.ui.components.PurpleButton

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel
){

    var email by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    var error by remember{
        mutableStateOf("")
    }

    Column(
        modifier=Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement=Arrangement.Center
    ){
        Text(
            "RideSafe",
            style=MaterialTheme.typography.headlineLarge,
            fontWeight=FontWeight.Bold
        )

        Spacer(modifier=Modifier.height(30.dp))

        CustomTextField(
            value=email,
            onValueChange={
                email=it
            },
            label="Email"
        )

        CustomTextField(
            value=password,
            onValueChange={
                password=it
            },
            label="Password"
        )

        Spacer(modifier=Modifier.height(20.dp))

        PurpleButton(
            text="LOGIN"
        ){
            viewModel.login(
                email,
                password
            )

            if(viewModel.state.isSuccess){
                navController.navigate(
                    Screen.Dashboard.route
                ){
                    popUpTo(Screen.Login.route){
                        inclusive = true
                    }
                }
            }
        }

        Spacer(modifier=Modifier.height(20.dp))

        TextButton(
            onClick={
                navController.navigate(
                    Screen.Register.route
                )
            }
        ){
            Text(
                "Create Account"
            )
        }
        Text(
            error
        )
    }
}