package classes.racas

import classes.Personagem
import interface_.Bonus

class AltoElfo(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.inteligencia += 1
        println("Bonus Racial do Alto Elfo Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Alto Elfo"
    }
}
