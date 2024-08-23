package Racas

import Interface.Bonus

class GnomoDasRochas(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.inteligencia += 2
        personagem.constituicao += 1
        println("Bonus Racial do Gnomo das Rochas Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Gnomo das Rochas";
    }
}

