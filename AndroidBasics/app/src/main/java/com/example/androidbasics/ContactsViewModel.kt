package com.example.androidbasics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContactsViewModel(
    var helloWord : String
) : ViewModel() {

    var backgroundcolor by mutableStateOf(Color.White)
        private set

    fun changeBackgroundColor(){
        backgroundcolor = Color.Red
    }

}