package Racas

import Interface.Bonus

class Tiefling(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.inteligencia += 1
        personagem.carisma += 2
        println("Bonus Racial do Tielfling Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Tielfling";
    }
}
