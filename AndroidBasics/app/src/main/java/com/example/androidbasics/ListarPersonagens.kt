package com.example.androidbasics

import android.app.Application
import android.content.Intent
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.androidbasics.data.database.AppDatabase
import com.example.androidbasics.data.entities.PersonagemEntity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androidbasics.data.ViewModel.PersonagemViewModel

class ListarPersonagens : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val vieModel = PersonagemViewModel(application)

            TelaPersonagens(vieModel)
        }
    }

    @Composable
    fun TelaPersonagens(viewModel: PersonagemViewModel) {
        val context = LocalContext.current
        val personagens by viewModel.personagens.observeAsState(emptyList())

        val scrollState = rememberScrollState()

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

                if (personagens.isEmpty()) {
                    Text(
                        text = "Nenhum personagem encontrado.", color = Color.White
                    )
                } else {
                    personagens.forEach { personagem ->
                        ExibirPersonagem(personagem)
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text("Voltar ao Menu", color = Color.White)
            }
        }
    }

    @Composable
    fun ExibirPersonagem(personagem: PersonagemEntity) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
                .background(Color.DarkGray)
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val imageSettings = Modifier
                    .size(100.dp)

                Image(
                    painter = painterResource(id = R.drawable.guerreiro_8bit),
                    contentDescription = null,
                    modifier = imageSettings,
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.nome),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )

                        Text(
                            text = "Nome: " + personagem.nome,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.raca),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )


                        Text(
                            text = "Raça: " + personagem.raca,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = R.drawable.hearth),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
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
        }
    }
}





