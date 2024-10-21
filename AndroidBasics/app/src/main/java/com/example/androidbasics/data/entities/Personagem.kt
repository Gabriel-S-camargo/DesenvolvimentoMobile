package com.example.androidbasics.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personagens")
data class PersonagemEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val nome: String,
    val raca: String,
    val vida : Int,
    val pontosDisponiveis : Int,
    val forca: Int,
    val destreza: Int,
    val constituicao: Int,
    val inteligencia: Int,
    val sabedoria: Int,
    val carisma: Int
)