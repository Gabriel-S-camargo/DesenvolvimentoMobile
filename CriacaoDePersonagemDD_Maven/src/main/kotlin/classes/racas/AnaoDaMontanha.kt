package classes.racas

import classes.Personagem
import interface_.Bonus

class AnaoDaMontanha (nome : String): Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.forca += 2
        println("Bonus Racial do Anão da Montanha Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Montanha"
    }

}