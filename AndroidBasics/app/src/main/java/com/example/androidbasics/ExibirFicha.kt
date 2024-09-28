package com.example.androidbasics

import Personagem
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import strategy.funcoes.racas

class ExibirFicha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
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

            val atributosBonus : Map <String, Int> = mapOf(
                "Força" to personagem.forca - forca ,
                "Destreza" to personagem.destreza- destreza,
                "Constituição" to personagem.constituicao - constituicao,
                "Inteligência" to personagem.inteligencia - inteligencia,
                "Sabedoria" to personagem.sabedoria - sabedoria,
                "Carisma" to personagem.carisma - carisma
            )

            Log.d("SecondActivity", "Personagem criado: $personagem")

            // Exibe as informações do personagem na tela com tema Material
            setContent {
                MaterialTheme {
                    PersonagemCriadoScreen(personagem, onBackClick = {
                        val intent = Intent(this@ExibirFicha, CriadorPersonagem::class.java)
                        startActivity(intent)
                        finish()
                    }, atributosBonus)
                }
            }
        } catch (e: Exception) {
            Log.e("SecondActivity", "Error creating Personagem: ${e.message}")
        }
    }
}

@Composable
fun PersonagemCriadoScreen(personagem: Personagem, onBackClick: () -> Unit, bonusRaca: Map<String, Int>) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            "Ficha do Seu Personagem",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Informações básicas
        InfoRow(label = "Nome:", value = personagem.nome, fontSize = 14)
        InfoRow(
            label = "Raça:",
            value = racas.entries.find { it.value == personagem.bonusRacial }?.key ?: "Desconhecida",
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
            Text("Atributo", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text("Nível", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text("Modificador", modifier = Modifier.weight(1f), fontSize = 14.sp)
            Text("Bônus Racial", modifier = Modifier.weight(1f), fontSize = 14.sp)
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
                bonusRaca = bonusRaca.getValue(atributo).toString()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para voltar
        Button(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Voltar Para a Tela de Criação de Personagem", fontSize = 14.sp)
        }
    }
}

@Composable
fun InfoRow(label: String, value: String, fontSize: Int = 16) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = fontSize.sp, modifier = Modifier.weight(1f))
        Text(text = value, fontSize = fontSize.sp, modifier = Modifier.weight(2f))
    }
}

@Composable
fun AttributeRow(label: String, nivel: String, modificador: String, bonusRaca: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Text(text = nivel, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Text(text = modificador, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Text(text = bonusRaca, modifier = Modifier.weight(1f), fontSize = 14.sp)
    }
}



