package com.example.androidbasics


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import strategy.funcoes.*



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
    var strength by remember { mutableStateOf("8") }
    var dexterity by remember { mutableStateOf("8") }
    var constitution by remember { mutableStateOf("8") }
    var intelligence by remember { mutableStateOf("8") }
    var wisdom by remember { mutableStateOf("8") }
    var charisma by remember { mutableStateOf("8") }
    var selectedRace by remember { mutableStateOf("Alto Elfo") }
    var remainingPoints by remember { mutableStateOf(27) }

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
        Text("Pontos Disponíveis: $remainingPoints")

        RaceDropdown(selectedRace = selectedRace, onRaceSelected = { selectedRace = it }, races = races)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome do Personagem") }
        )

        // Atributos com validação de pontos ao trocar de campo
        AtributoInput("Força", strength, remainingPoints) { newStrength ->
            strength = newStrength
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }
        AtributoInput("Destreza", dexterity, remainingPoints) { newDexterity ->
            dexterity = newDexterity
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }
        AtributoInput("Constituição", constitution, remainingPoints) { newConstitution ->
            constitution = newConstitution
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }
        AtributoInput("Inteligência", intelligence, remainingPoints) { newIntelligence ->
            intelligence = newIntelligence
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }
        AtributoInput("Sabedoria", wisdom, remainingPoints) { newWisdom ->
            wisdom = newWisdom
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }
        AtributoInput("Carisma", charisma, remainingPoints) { newCharisma ->
            charisma = newCharisma
            remainingPoints = calcularPontosRestantes(listOf(strength, dexterity, constitution, intelligence, wisdom, charisma))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                /*var racaFinal = converterStringParaBonusRacial(selectedRace)

                // Criação do personagem
                var personagem = criarPersonagem(
                    racaFinal,
                    strength.toInt(),
                    dexterity.toInt(),
                    constitution.toInt(),
                    intelligence.toInt(),
                    wisdom.toInt(),
                    charisma.toInt()
                )

                 */
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
fun AtributoInput(label: String, value: String, remainingPoints: Int, onValueChange: (String) -> Unit) {
    val attributeValues = (8..15).map { it.toString() }
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = {  },
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
        )

        if (expanded) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Limita a altura do dropdown
            ) {
                items(attributeValues) { attribute ->
                    val cost = calcularCustoAtributo(attribute.toInt())

                    // Permite alterar o valor somente se houver pontos suficientes
                    if (remainingPoints + calcularCustoAtributo(value.toInt()) >= cost) {
                        Text(
                            text = "$attribute (Custo: $cost)",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    onValueChange(attribute)
                                    expanded = false
                                }
                        )
                    } else {
                        // Exibe o atributo como desabilitado se o custo for maior que os pontos restantes
                        Text(
                            text = "$attribute (Custo: $cost)",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                        )
                    }
                }
            }
        }
    }
}

// Dropdown para selecionar a raça
@Composable
fun RaceDropdown(selectedRace: String, onRaceSelected: (String) -> Unit, races: List<String>) {
    var expanded by remember { mutableStateOf(false) }

    Column {
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











