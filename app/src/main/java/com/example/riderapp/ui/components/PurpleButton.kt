package com.example.riderapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PurpleButton(

    text:String,

    enabled:Boolean=true,

    onClick:()->Unit

){

    Button(

        enabled=enabled,

        onClick=onClick,

        modifier=Modifier
            .fillMaxWidth()
            .height(56.dp),

        shape= RoundedCornerShape(16.dp)

    ){

        Text(text)

    }

}