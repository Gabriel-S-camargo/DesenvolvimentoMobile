package classes.racas

import classes.Personagem
import interface_.Bonus

class Draconato(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.forca += 2
        personagem.carisma += 1
        println("Bonus Racial do Draconato Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Draconato"
    }
}
