package classes.racas

import classes.Personagem
import interface_.Bonus

class MeioOrc(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.forca += 2
        personagem.constituicao += 1
        println("Bonus Racial do Meio-Orc Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Meio-Orc"
    }
}
