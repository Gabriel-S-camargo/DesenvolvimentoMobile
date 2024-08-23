package Racas

import Interface.Bonus

class AltoElfo(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.inteligencia += 2
        personagem.sabedoria += 1
        println("Bonus Racial do Alto Elfo Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Alto Elfo";
    }
}
