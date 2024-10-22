package com.example.androidbasics

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import strategy.funcoes.*
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

class CriadorPersonagem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fromActivity = intent.getStringExtra("fromActivity") ?: "Desconhecido"
        val id = intent.getIntExtra("id", 0)

        setContent {
            CharacterFormScreen(fromActivity, id)
        }
    }
}

@Composable
fun CharacterFormScreen(foreignActivity : String, id : Int) {

    var name by rememberSaveable { mutableStateOf("") }
    var strength by rememberSaveable { mutableStateOf("8") }
    var dexterity by rememberSaveable { mutableStateOf("8") }
    var constitution by rememberSaveable { mutableStateOf("8") }
    var intelligence by rememberSaveable { mutableStateOf("8") }
    var wisdom by rememberSaveable { mutableStateOf("8") }
    var charisma by rememberSaveable { mutableStateOf("8") }
    var selectedRace by rememberSaveable { mutableStateOf("Alto Elfo") }
    var remainingPoints by rememberSaveable { mutableIntStateOf(27) }

    // Esse cara aqui serve para poder lembrar a Orientação do Dispositivo e
    // permitir a rolagem
    //val scrollState = rememberScrollState()

    val races = listOf(
        "Alto elfo", "Anão", "Anão da Montanha", "Anão da Colina", "Drow", "Draconato",
        "Elfo", "Elfo da Floresta", "Gnomo", "Gnomo da Floresta", "Gnomo das Rochas",
        "Halfling", "Halfling Pés-Leves", "Halfling Robusto", "Humano", "Meio-Elfo",
        "Meio-Orc", "Tiefling"
    )

    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.backgroundapp),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .then(
                    if (isLandscape) Modifier.verticalScroll(scrollState) else Modifier
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Criador de Personagem Dungeons And Dragons",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
            Text(
                "Pontos Disponíveis: $remainingPoints",
                fontSize = 24.sp,
                color = Color.White
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome do Personagem") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White,
                    focusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            // Campo para a seleção da raça
            RaceDropdown(
                selectedRace = selectedRace,
                onRaceSelected = { selectedRace = it },
                races = races
            )

            // Campos para os atributos (Força, Destreza, Constituição, etc.)
            AtributoInput("Força", strength, remainingPoints) { newStrength ->
                strength = newStrength
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }
            AtributoInput("Destreza", dexterity, remainingPoints) { newDexterity ->
                dexterity = newDexterity
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }
            AtributoInput("Constituição", constitution, remainingPoints) { newConstitution ->
                constitution = newConstitution
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }
            AtributoInput("Inteligência", intelligence, remainingPoints) { newIntelligence ->
                intelligence = newIntelligence
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }
            AtributoInput("Sabedoria", wisdom, remainingPoints) { newWisdom ->
                wisdom = newWisdom
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }
            AtributoInput("Carisma", charisma, remainingPoints) { newCharisma ->
                charisma = newCharisma
                remainingPoints = calcularPontosRestantes(
                    listOf(
                        strength,
                        dexterity,
                        constitution,
                        intelligence,
                        wisdom,
                        charisma
                    )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        try {
                            val intent = Intent(context, ExibirFicha::class.java).apply {
                                if(foreignActivity != "ListarPersonagens"){
                                    putExtra("fromActivity", "CriadorPersonagem")
                                    putExtra("nome", name)
                                    putExtra("raca", selectedRace)
                                    putExtra("forca", strength.toInt())
                                    putExtra("destreza", dexterity.toInt())
                                    putExtra("constituicao", constitution.toInt())
                                    putExtra("inteligencia", intelligence.toInt())
                                    putExtra("sabedoria", wisdom.toInt())
                                    putExtra("carisma", charisma.toInt())

                                }else{
                                    putExtra("fromActivity", "ListarPersonagemOrigin")
                                    putExtra("id", id)
                                    putExtra("nome", name)
                                    putExtra("raca", selectedRace)
                                    putExtra("forca", strength.toInt())
                                    putExtra("destreza", dexterity.toInt())
                                    putExtra("constituicao", constitution.toInt())
                                    putExtra("inteligencia", intelligence.toInt())
                                    putExtra("sabedoria", wisdom.toInt())
                                    putExtra("carisma", charisma.toInt())
                                }


                            }
                            Log.d(
                                "MainActivity",
                                "Intent created successfully with: Nome=$name, Raça=$selectedRace"
                            )
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            Log.e("MainActivity", "Error creating intent: ${e.message}")
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text("Criar Personagem", color = Color.Black)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Button(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent

                    )
                )
                {
                    Text("Voltar ao Menu", color = Color.White)
                }
            }
        }


    }


}


@Composable
fun AtributoInput(
    label: String,
    value: String,
    remainingPoints: Int,
    onValueChange: (String) -> Unit
) {
    val attributeValues = (8..15).map { it.toString() }
    var expanded by remember { mutableStateOf(false) }
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = { },
            label = { Text(label) },
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                focusedLeadingIconColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(horizontal = 20.dp)
        )
        if (expanded) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp) // Limita a altura do dropdown
                    .background(Color.White),

                ) {
                items(attributeValues) { attribute ->
                    val cost = calcularCustoAtributo(attribute.toInt())

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

    Column(
        modifier = Modifier
    ) {
        OutlinedTextField(
            value = selectedRace,
            onValueChange = { /* Campo somente de leitura */ },
            label = { Text("Raça do Personagem") },
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedTextColor = Color.White,
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                focusedLeadingIconColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(horizontal = 20.dp)
        )
        if (expanded) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White)
                    .padding(horizontal = 20.dp)
            ) {
                items(races) { race ->
                    Text(
                        text = race,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                onRaceSelected(race)
                                expanded = false
                            },
                    )
                }
            }
        }
    }
}












