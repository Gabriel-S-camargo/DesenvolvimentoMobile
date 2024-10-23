package com.example.androidbasics

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.androidbasics.data.entities.PersonagemEntity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.androidbasics.data.viewModel.PersonagemViewModel

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

    private fun enviarValores(
        activityDestino: Class<out ComponentActivity>,
        context: Context,
        personagem: PersonagemEntity
    ) {
        try {
            val intent = Intent(context, activityDestino).apply {
                putExtra("fromActivity", "ListarPersonagens")
                putExtra("id", personagem.id)
                putExtra("nome", personagem.nome)
                putExtra("raca", personagem.raca)
                putExtra("forca", personagem.forca)
                putExtra("destreza", personagem.destreza)
                putExtra("constituicao", personagem.constituicao)
                putExtra("inteligencia", personagem.inteligencia)
                putExtra("sabedoria", personagem.sabedoria)
                putExtra("carisma", personagem.carisma)
            }
            Log.d("Buscar Personagem", "Personagem Enviado ao CriadorPersonagem")
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e("Buscar Personagem", "Erro de envio ao CriadorPersonagem: ${e.message}")
        }
    }

    @Composable
    fun ExibirPersonagem(personagem: PersonagemEntity) {
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
                .background(Color.DarkGray)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.guerreiro_8bit),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    StatisticaPersonagem("ID: ${personagem.id}", R.drawable.nome)
                    StatisticaPersonagem("Nome: ${personagem.nome}", R.drawable.nome)
                    StatisticaPersonagem("Raça: ${personagem.raca}", R.drawable.raca)
                    StatisticaPersonagem("Vida: ${personagem.vida}", R.drawable.hearth)
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        val viewModel = PersonagemViewModel(Application())
                        try {
                            viewModel.deletarPersonagem(personagem)
                            val mIntent = intent
                            finish()
                            startActivity(mIntent)
                            Log.e("DeletePersonagem", "Personagem Deletado!!")
                        } catch (e: Exception) {
                            Log.e("DeletePersonagem", "Erro de Deleção: ${e.message}")
                        }
                    }
                ) {
                    Text("Deletar")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        enviarValores(ExibirFicha::class.java, context, personagem)
                    }
                ) {
                    Text("Exibir Ficha")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        enviarValores(CriadorPersonagem::class.java, context, personagem)
                    }
                ) {
                    Text("Trocar Atributos")
                }
            }
        }
    }

    @Composable
    fun StatisticaPersonagem(texto: String, iconRes: Int) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}






