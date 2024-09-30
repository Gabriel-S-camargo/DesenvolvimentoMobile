package com.example.androidbasics.data.conversores

import Personagem
import bonusRacial.BonusRacial
import com.example.androidbasics.data.entities.PersonagemEntity
import strategy.funcoes.racas

// Extensão para converter Personagem para PersonagemEntity
fun Personagem.toEntity(): PersonagemEntity {
    return PersonagemEntity(
        nome = this.nome,
        pontosDisponiveis = this.pontosDisponiveis,
        // assim posso pegar a Key do meu HashMap Racas, pegando a raca a partir do Bonus Racial
        raca = racas.filterValues { it == this.bonusRacial }.keys.toString(),
        forca = this.forca,
        destreza = this.destreza,
        constituicao = this.constituicao,
        inteligencia = this.inteligencia,
        sabedoria = this.sabedoria,
        carisma = this.carisma,
        vida = this.vida
    )
}


// Extensão para converter PersonagemEntity para Personagem
fun PersonagemEntity.toPersonagem(bonusRacial: BonusRacial): Personagem {
    val personagem = Personagem(bonusRacial)
    personagem.nome = this.nome
    personagem.pontosDisponiveis = this.pontosDisponiveis
    personagem.forca = this.forca
    personagem.destreza = this.destreza
    personagem.constituicao = this.constituicao
    personagem.inteligencia = this.inteligencia
    personagem.sabedoria = this.sabedoria
    personagem.carisma = this.carisma
    personagem.vida = this.vida
    return personagem
}