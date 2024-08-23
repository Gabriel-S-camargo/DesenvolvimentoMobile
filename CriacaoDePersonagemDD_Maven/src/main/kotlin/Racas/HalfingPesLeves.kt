package Racas

import Interface.Bonus

class HalfingPesLeves(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.destreza += 2
        personagem.carisma += 1
        println("Bonus Racial do Halfing Pés-Leves Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Halfing Pés-Leves";
    }
}
