package com.example.androidbasics

import Personagem
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasics.ui.theme.AndroidBasicsTheme
import strategy.bonusRacial.*


class MyClass(private val context : Context){
    // assim que conecta um classe ao android
}



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var myActivity = Personagem(Anao())


        val viewModel: ContactsViewModel by viewModels {
            object : ViewModelProvider.Factory {
                 override fun <T : ViewModel> create(modelClass: Class<T>): T {
                     return ContactsViewModel(helloWord = "Hello World") as T

                }
            }
        }

        setContent {
            MaterialTheme {
                // Define a cor de fundo para a tela
                var backgroundColor = viewModel.backgroundcolor

                // Layout principal
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                        .padding(16.dp)
                ) {
                    // Row para alinhar os botões horizontalmente
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Botão para mudar a cor
                        Button(
                            onClick = {
                                viewModel.changeBackgroundColor()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Change Color")
                        }

                        Spacer(modifier = Modifier.width(16.dp)) // Espaçamento entre os botões

                        // Botão para retornar à cor original
                        Button(
                            onClick = {
                                viewModel.changeBackgroundColorDefault()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Return Color")
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