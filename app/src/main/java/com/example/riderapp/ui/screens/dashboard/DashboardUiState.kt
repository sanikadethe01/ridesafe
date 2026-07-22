package com.example.riderapp.ui.screens.dashboard

data class DashboardUiState(
    val userName:String="",
    val destination:String="",
    val eta:Int=15,
    val loading:Boolean=false,
    val error:String=""
)