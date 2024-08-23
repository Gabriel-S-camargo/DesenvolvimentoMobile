package Racas

import Interface.Bonus

class Halfing(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.destreza += 2
        println("Bonus Racial do Halfing Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Halfing";
    }
}
