package Racas

import Interface.Bonus

class Draconato(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.forca += 2
        personagem.carisma += 1
        println("Bonus Racial do Draconato Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Draconato";
    }
}
