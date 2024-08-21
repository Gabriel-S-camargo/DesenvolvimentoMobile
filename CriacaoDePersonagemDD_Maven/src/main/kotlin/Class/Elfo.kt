package Class

import Interface.Bonus
import Class.AnaoDaMontanha
import Class.Personagem

class Elfo : Personagem(), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.destreza += 2
        personagem.inteligencia += 1
        personagem.sabedoria += 1
        personagem.carisma += 1
        println("Bonus Racial Do Elfo Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Elfo";
    }

}