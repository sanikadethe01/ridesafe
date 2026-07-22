package com.example.riderapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value:String,
    onValueChange:(String)->Unit,
    label:String,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value=value,
        onValueChange=onValueChange,
        label={ Text(label) },
        shape= RoundedCornerShape(16.dp),
        modifier=modifier
            .fillMaxWidth()
            .padding(vertical=6.dp)
    )
}