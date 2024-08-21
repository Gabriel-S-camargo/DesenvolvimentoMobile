package Class

import Interface.Bonus
import Class.AnaoDaMontanha
import Class.Personagem

class AnaoDaMontanha : Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.forca + 2
        personagem.constituicao + 2
        println("Anão forte, Forca e constituicao + 2")
    }


    override fun toString(): String {
        return super.toString() + "\nAnão da Montanha";
    }

}