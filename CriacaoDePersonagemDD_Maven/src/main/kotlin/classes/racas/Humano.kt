package classes.racas

import classes.Personagem
import interface_.Bonus

class Humano(nome : String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.forca +=1
        personagem.destreza +=1
        personagem.constituicao +=1
        personagem.inteligencia +=1
        personagem.sabedoria +=1
        personagem.carisma +=1
        println("Bonus Racial Do Humano Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Humano"
    }

}