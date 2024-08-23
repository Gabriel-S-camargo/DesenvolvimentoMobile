package classes.racas

import classes.Personagem
import interface_.Bonus

class Anao(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.constituicao += 2
        println("Bonus Racial do Anão Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão"
    }
}
