package com.example.androidbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.androidbasics.data.database.AppDatabase
import com.example.androidbasics.data.entities.PersonagemEntity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class ListarPersonagens : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaPersonagens()
        }
    }

    @Composable
    fun TelaPersonagens() {
        val context = LocalContext.current
        val db = remember { AppDatabase.getDatabase(context) }
        val personagemDao = db.personagemDao()
        var personagens by remember { mutableStateOf(emptyList<PersonagemEntity>()) }
        val scrollState = rememberScrollState()


        // Carrega os personagens do banco de dados
        LaunchedEffect(Unit) {
            personagens = personagemDao.buscarTodos()
        }

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.backgroundapp),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = "Personagens Criados",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )

                // Verifica se há personagens no banco de dados
                if (personagens.isEmpty()) {
                    Text(text = "Nenhum personagem encontrado.", color = Color.White)
                } else {
                    // Exibe a lista de personagens
                    personagens.forEach { personagem ->
                        ExibirPersonagem(personagem)
                    }
                }
            }
        }
    }

    @Composable
    fun ExibirPersonagem(personagem: PersonagemEntity) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp)) // Primeiro o clip para arredondar as bordas
                .border(2.dp, Color.Gray, RoundedCornerShape(10.dp)) // Depois a borda com o mesmo arredondamento
                .background(Color.DarkGray) 
                .padding(8.dp)
        ) {
            Text(
                text = "Nome: " + personagem.nome,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
            )
            Text(
                text = "Raça: " + personagem.raca,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
            )
            Text(
                text = "Vida: " + personagem.vida,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }

}
