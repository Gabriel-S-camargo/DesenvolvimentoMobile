package com.example.androidbasics

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainMenu()
        }
    }
}

@Composable
fun MainMenu() {
    // Esse cara aqui pega o valor da Context/Activity Atual, possibilitando a navegação, não esquecer desse cara
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dungeons and Dragons Lite",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "Selecione um menu desejado")

        // Botão para criar personagem
        Button(
            onClick = {
                val intent = Intent(context, CriadorPersonagem::class.java)
                context.startActivity(intent)
            },

        ) {
            Text(text = "Criador de Personagem")
        }

        // Botão para consultar personagens
        Button(
            onClick = {
                val intent = Intent(context, ListarPersonagens::class.java)
                context.startActivity(intent)
            },

        ) {
            Text(text = "Consultar Personagens")
        }
    }
}
