package Racas

import Interface.Bonus

class Anao(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.constituicao += 2
        println("Bonus Racial do Anão Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão";
    }
}
