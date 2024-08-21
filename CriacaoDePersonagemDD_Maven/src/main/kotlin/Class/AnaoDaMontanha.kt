package Class

import Interface.Bonus
import Class.AnaoDaMontanha
import Class.Personagem

class AnaoDaMontanha : Personagem(), Bonus {




    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.forca += 2
        personagem.constituicao += 2
        println("Bonus Racial do Anão da Montanha Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Montanha";
    }

}