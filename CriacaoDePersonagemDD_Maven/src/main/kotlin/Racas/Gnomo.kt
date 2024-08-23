package Racas

import Interface.Bonus

class Gnomo(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.inteligencia += 2
        println("Bonus Racial do Gnomo Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Gnomo";
    }
}
