package com.example.androidbasics


import Personagem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import strategy.bonusRacial.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterFormScreen()
        }
    }

}


@Composable
fun CharacterFormScreen() {
    var name by remember { mutableStateOf("") }
    var strength by remember { mutableStateOf("") }
    var dexterity by remember { mutableStateOf("") }
    var constitution by remember { mutableStateOf("") }
    var intelligence by remember { mutableStateOf("") }
    var wisdom by remember { mutableStateOf("") }
    var charisma by remember { mutableStateOf("") }
    var selectedRace by remember { mutableStateOf("Alto Elfo") }

    val races = listOf(
        "Alto elfo", "Anão", "Anão da Montanha", "Anão da Colina", "Drow", "Draconato",
        "Elfo", "Elfo da Floresta", "Gnomo", "Gnomo da Floresta", "Gnomo das Rochas",
        "Halfling", "Halfling Pés-Leves", "Halfling Robusto", "Humano", "Meio-Elfo",
        "Meio-Orc", "Tiefling"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Criador de Personagem Dungeons And Dragons", style = MaterialTheme.typography.headlineMedium)
        Text("Pontos Disponíveis: 27")
        // Campo para Nome
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome do Personagem") }
        )

        AtributoInput("Força", strength) { strength = it }
        AtributoInput("Destreza", dexterity) { dexterity = it }
        AtributoInput("Constituição", constitution) { constitution = it }
        AtributoInput("Inteligência", intelligence) { intelligence = it }
        AtributoInput("Sabedoria", wisdom) { wisdom = it }
        AtributoInput("Carisma", charisma) { charisma = it }

        RaceDropdown(selectedRace = selectedRace, onRaceSelected = { selectedRace = it }, races = races)


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {

                //var finalRace

                //var personagem = Personagem(bonusRacial = )
            }) {
                Text("Criar Personagem")

            }

            Button(onClick = {
                // Ação para consultar modificadores
            }) {
                Text("Consultar Modificadores")
            }
        }
    }
}

@Composable
fun AtributoInput(label: String, value: String, onValueChange: (String) -> Unit) {
    val attributeValues = (8..15).map { it.toString() }
    var expanded by remember { mutableStateOf(false) }

    Column {
        // Campo de seleção de valor para o atributo
        OutlinedTextField(
            value = value,
            onValueChange = {  },
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
        )

        // Exibe as opções de 8 a 15 como um Dropdown
        if (expanded) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Limita a altura do dropdown
            ) {
                items(attributeValues) { attribute ->
                    Text(
                        text = attribute,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                onValueChange(attribute) // Atualiza o valor selecionado
                                expanded = false // Fecha o dropdown ao selecionar
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun RaceDropdown(selectedRace: String, onRaceSelected: (String) -> Unit, races: List<String>) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        // Campo de seleção de Raça
        OutlinedTextField(
            value = selectedRace,
            onValueChange = { /* Campo somente de leitura */ },
            label = { Text("Raça do Personagem") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded } // Controla a expansão da lista
        )

        // Exibição da lista de raças usando LazyColumn quando expandido
        if (expanded) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Limita o tamanho da lista
            ) {
                items(races) { race ->
                    Text(
                        text = race,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                onRaceSelected(race)
                                expanded = false // Fecha a lista ao selecionar
                            }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CharacterFormScreenPreview() {
    CharacterFormScreen()
}
