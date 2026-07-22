package com.example.riderapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp

@Composable
fun PasswordField(

    value:String,

    onValueChange:(String)->Unit,

    label:String

){

    var visible by remember{
        mutableStateOf(false)
    }

    OutlinedTextField(

        value=value,

        onValueChange=onValueChange,

        modifier=Modifier
            .fillMaxWidth()
            .padding(vertical=6.dp),

        label={
            Text(label)
        },

        shape= RoundedCornerShape(14.dp),

        visualTransformation=
            if(visible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),

        trailingIcon={

            IconButton(
                onClick={
                    visible=!visible
                }
            ){

//                Icon(
//
//                    imageVector=
//                        if(visible)
//                            Icons.Default.Visibility
//                        else
//                            Icons.Default.VisibilityOff,
//
//                    contentDescription=null
//
//                )

            }

        }

    )

}