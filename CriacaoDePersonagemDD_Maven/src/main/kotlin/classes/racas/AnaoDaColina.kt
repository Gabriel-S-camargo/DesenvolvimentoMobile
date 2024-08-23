package classes.racas

import classes.Personagem
import interface_.Bonus

class AnaoDaColina(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.constituicao += 2
        personagem.sabedoria += 1
        println("Bonus Racial do Anão da Colina Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Colina"
    }
}
