package Racas

import Interface.Bonus

class Elfo (nome : String): Personagem(nome), Bonus {

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