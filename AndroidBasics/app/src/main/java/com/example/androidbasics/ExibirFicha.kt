package com.example.androidbasics

import Personagem
import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import strategy.funcoes.converterStringParaBonusRacial
import strategy.funcoes.criarPersonagem
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.androidbasics.data.viewModel.PersonagemViewModel
import com.example.androidbasics.data.conversores.toEntity
import com.example.androidbasics.data.conversores.toPersonagem
import strategy.funcoes.racas

class ExibirFicha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun createContent(personagem: Personagem, bonusRaca: Map<String, Int>, activity: String) {
            setContent {
                MaterialTheme {
                    PersonagemCriadoScreen(
                        personagem,
                        onBackClick = {
                            val intent =
                                Intent(this@ExibirFicha, CriadorPersonagem::class.java)
                            startActivity(intent)
                            finish()
                        },
                        bonusRaca, activity
                    )
                }
            }
        }

        when (val fromActivity = intent.getStringExtra("fromActivity")) {
            "ListarPersonagens" -> {

                Log.e("ExibirFicha", "Origem ListarPersonagem")

                // Obtém o ID passado pela Intent
                val id = intent.getIntExtra("id", 0)
                val raca = intent.getStringExtra("raca") ?: "Desconhecida"
                val forca = intent.getIntExtra("forca", 8)
                val destreza = intent.getIntExtra("destreza", 8)
                val constituicao = intent.getIntExtra("constituicao", 8)
                val inteligencia = intent.getIntExtra("inteligencia", 8)
                val sabedoria = intent.getIntExtra("sabedoria", 8)
                val carisma = intent.getIntExtra("carisma", 8)
                val viewModel = PersonagemViewModel(application)

                viewModel.buscarPersonagemPorId(id).observe(this) { personagemEntity ->
                    // Verifica se o personagem foi encontrado
                    personagemEntity?.let { entity ->
                        // Converte PersonagemEntity para Personagem
                        val personagem = entity.toPersonagem(converterStringParaBonusRacial(raca))

                        val atributosBonus: Map<String, Int> = mapOf(
                            "Força" to personagem.forca - forca,
                            "Destreza" to personagem.destreza - destreza,
                            "Constituição" to personagem.constituicao - constituicao,
                            "Inteligência" to personagem.inteligencia - inteligencia,
                            "Sabedoria" to personagem.sabedoria - sabedoria,
                            "Carisma" to personagem.carisma - carisma
                        )

                        createContent(
                            personagem = personagem,
                            bonusRaca = atributosBonus,
                            activity = fromActivity
                        )

                    } ?: run {
                        Log.e("ExibirFicha", "Personagem não encontrado.")
                    }
                }
            }

            "CriadorPersonagem" -> {

                Log.e("ExibirFicha", "Origem CriadorDePersonagem")

                // Recupera os dados do Intent
                val nome = intent.getStringExtra("nome") ?: "Desconhecido"
                val raca = intent.getStringExtra("raca") ?: "Desconhecida"
                val forca = intent.getIntExtra("forca", 8)
                val destreza = intent.getIntExtra("destreza", 8)
                val constituicao = intent.getIntExtra("constituicao", 8)
                val inteligencia = intent.getIntExtra("inteligencia", 8)
                val sabedoria = intent.getIntExtra("sabedoria", 8)
                val carisma = intent.getIntExtra("carisma", 8)

                // Cria o personagem usando os dados recebidos
                val personagem = criarPersonagem(
                    nome = nome,
                    bonusRacial = converterStringParaBonusRacial(raca),
                    forca = forca,
                    destreza = destreza,
                    constituicao = constituicao,
                    inteligencia = inteligencia,
                    sabedoria = sabedoria,
                    carisma = carisma
                )

                val atributosBonus: Map<String, Int> = mapOf(
                    "Força" to personagem.forca - forca,
                    "Destreza" to personagem.destreza - destreza,
                    "Constituição" to personagem.constituicao - constituicao,
                    "Inteligência" to personagem.inteligencia - inteligencia,
                    "Sabedoria" to personagem.sabedoria - sabedoria,
                    "Carisma" to personagem.carisma - carisma
                )

                Log.d("SecondActivity", "Personagem criado: $personagem")

                createContent(
                    personagem = personagem,
                    bonusRaca = atributosBonus,
                    activity = fromActivity
                )

            }

            "ListarPersonagemOrigin" -> {

                Log.e("ExibirFicha", "Origem ListarPersonagemOrigin")

                // Obtém o ID passado pela Intent
                val id = intent.getIntExtra("id", 0)
                val nome = intent.getStringExtra("nome") ?: "Desconhecido"
                val raca = intent.getStringExtra("raca") ?: "desconhecida"
                val forca = intent.getIntExtra("forca", 8)
                val destreza = intent.getIntExtra("destreza", 8)
                val constituicao = intent.getIntExtra("constituicao", 8)
                val inteligencia = intent.getIntExtra("inteligencia", 8)
                val sabedoria = intent.getIntExtra("sabedoria", 8)
                val carisma = intent.getIntExtra("carisma", 8)
                val viewModel = PersonagemViewModel(application)

                // Cria o personagem usando os dados recebidos
                val personagem = criarPersonagem(
                    nome = nome,
                    bonusRacial = converterStringParaBonusRacial(raca),
                    forca = forca,
                    destreza = destreza,
                    constituicao = constituicao,
                    inteligencia = inteligencia,
                    sabedoria = sabedoria,
                    carisma = carisma
                )

                val atributosBonus: Map<String, Int> = mapOf(
                    "Força" to personagem.forca - forca,
                    "Destreza" to personagem.destreza - destreza,
                    "Constituição" to personagem.constituicao - constituicao,
                    "Inteligência" to personagem.inteligencia - inteligencia,
                    "Sabedoria" to personagem.sabedoria - sabedoria,
                    "Carisma" to personagem.carisma - carisma
                )

                try {

                    val personagemEntity = personagem.toEntity()

                    personagemEntity.id = id

                    viewModel.atualizarPersonagem(personagemEntity)

                    Log.e("Exibir Ficha", "Atualizado")
                } catch (e: Exception) {
                    Log.e("ExibirFicha", "Erro de Atualizaçãp: ${e.message}")
                }

                createContent(
                    personagem = personagem,
                    bonusRaca = atributosBonus,
                    activity = fromActivity
                )
            }

        }
    }
}

@Composable
fun PersonagemCriadoScreen(
    personagem: Personagem,
    onBackClick: () -> Unit,
    bonusRaca: Map<String, Int>,
    activity: String
) {
    val scrollState = rememberScrollState()

    val context = LocalContext.current

    // acessa a viewModel para poder inserir o personagem

    if (activity == "CriadorPersonagem") {
        try {

            val application = context.applicationContext as Application

            val viewModel = PersonagemViewModel(application)

            viewModel.inserirPersonagem(personagem)

            Log.e("ExibirFicha", "Personagem Inserido com sucesso!!")

        } catch (e: Exception) {

            Log.e("ExibirFicha", "Erro de inserção: ${e.message}")

        }
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
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
                .background(Color.DarkGray)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text(
                "Ficha do Seu Personagem",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color.White
            )

            // Informações básicas
            InfoRow(label = "Nome:", value = personagem.nome, fontSize = 14)
            InfoRow(
                label = "Raça:",
                value = racas.entries.find { it.value == personagem.bonusRacial }?.key
                    ?: "Desconhecida",
                fontSize = 14
            )
            InfoRow(label = "Vida:", value = personagem.vida.toString(), fontSize = 14)

            Spacer(modifier = Modifier.height(16.dp))

            // Cabeçalho para Atributos e Modificadores
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Atributo",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.White
                )
                Text("Nível", modifier = Modifier.weight(1f), fontSize = 14.sp, color = Color.White)
                Text(
                    "Modificador",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.White
                )
                if (activity != "ListarPersonagens") {
                    Text(
                        "Bônus Racial",
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

            }

            // Exibindo os atributos e modificadores
            listOf(
                "Força" to personagem.forca,
                "Destreza" to personagem.destreza,
                "Constituição" to personagem.constituicao,
                "Inteligência" to personagem.inteligencia,
                "Sabedoria" to personagem.sabedoria,
                "Carisma" to personagem.carisma
            ).forEach { (atributo, valor) ->
                AttributeRow(
                    label = "$atributo:",
                    nivel = valor.toString(),
                    modificador = personagem.calculaModificador(valor).toString(),
                    bonusRaca = bonusRaca.getValue(atributo).toString(),
                    activity
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                // Botão para voltar
                Button(
                    onClick = onBackClick,
                    modifier = Modifier.padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        "Voltar Para a Tela de Criação de Personagem",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Button(
                    onClick = {
                        val intent = Intent(context, ListarPersonagens::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text("Consultar Personagens Criados", fontSize = 14.sp, color = Color.Black)
                }
            }

        }


    }


}

@Composable
fun InfoRow(label: String, value: String, fontSize: Int = 16) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = fontSize.sp,
            modifier = Modifier.weight(1f),
            color = Color.White
        )
        Text(
            text = value,
            fontSize = fontSize.sp,
            modifier = Modifier.weight(2f),
            color = Color.White
        )
    }
}

@Composable
fun AttributeRow(
    label: String,
    nivel: String,
    modificador: String,
    bonusRaca: String,
    activity: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, modifier = Modifier.weight(1f), fontSize = 14.sp, color = Color.White)
        Text(text = nivel, modifier = Modifier.weight(1f), fontSize = 14.sp, color = Color.White)
        Text(
            text = modificador,
            modifier = Modifier.weight(1f),
            fontSize = 14.sp,
            color = Color.White
        )
        if (activity != "ListarPersonagens") {
            Text(
                text = bonusRaca,
                modifier = Modifier.weight(1f),
                fontSize = 14.sp,
                color = Color.White
            )
        }

    }
}




