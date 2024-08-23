package classes.racas

import classes.Personagem
import interface_.Bonus

class Tiefling(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.inteligencia += 1
        personagem.carisma += 2
        println("Bonus Racial do Tielfling Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Tielfling"
    }
}
