package classes.racas

import classes.Personagem
import interface_.Bonus

class Elfo (nome : String): Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.destreza += 2
        personagem.inteligencia += 1
        personagem.sabedoria += 1
        personagem.carisma += 1
        println("Bonus Racial Do Elfo Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Elfo"
    }

}