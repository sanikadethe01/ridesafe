package com.example.riderapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun EtaChip(

    text:String,

    selected:Boolean,

    onClick:()->Unit

){

    FilterChip(

        selected=selected,

        onClick=onClick,

        label={

            Text(text)

        }

    )

}