package Racas

import Interface.Bonus

class AnaoDaColina(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.constituicao += 2
        personagem.sabedoria += 1
        println("Bonus Racial do Anão da Colina Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Colina";
    }
}
