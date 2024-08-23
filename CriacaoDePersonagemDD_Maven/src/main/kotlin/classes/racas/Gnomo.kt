package classes.racas

import classes.Personagem
import interface_.Bonus

class Gnomo(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.inteligencia += 2
        println("Bonus Racial do Gnomo Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Gnomo"
    }
}
