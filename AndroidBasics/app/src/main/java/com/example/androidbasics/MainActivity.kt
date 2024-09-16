package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasics.ui.theme.AndroidBasicsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: ContactsViewModel by viewModels {
            object : ViewModelProvider.Factory {
                 override fun <T : ViewModel> create(modelClass: Class<T>): T {
                     return ContactsViewModel(helloWord = "Hello World") as T

                }
            }
        }

        setContent {
            AndroidBasicsTheme {
                val backgroundColor = viewModel.backgroundcolor

                Scaffold { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                            .padding(innerPadding)
                    ) {
                        Button(
                            onClick = {
                                viewModel.changeBackgroundColor()
                            }
                        ) {
                            Text(text = "Change Color")
                        }
                    }
                }
            }
        }
    }

    override fun onStart(){
        super.onStart()
        println("onStart()")
    }
    override fun onResume(){
        super.onResume()
        println("onResume()")
    }
    override fun onPause(){
        super.onPause()
        println("onPause()")
    }
    override fun onStop(){
        super.onStop()
        println("onStop()")
    }

    override fun onDestroy(){
        super.onDestroy()
        println("onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        println("OnRestart()")
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidBasicsTheme {
        Greeting("Android")
    }
}