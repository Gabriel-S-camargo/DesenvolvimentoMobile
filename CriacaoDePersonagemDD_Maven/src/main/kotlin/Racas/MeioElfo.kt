package Racas

import Interface.Bonus

class MeioElfo(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.carisma += 2
        personagem.inteligencia += 1 // Pode ser distribuído para outros atributos, aqui é um exemplo
        println("Bonus Racial do Meio-Elfo Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Meio-Elfo";
    }
}
