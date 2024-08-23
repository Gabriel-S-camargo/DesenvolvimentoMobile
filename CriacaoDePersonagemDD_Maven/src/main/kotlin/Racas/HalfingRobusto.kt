package Racas

import Interface.Bonus

class HalfingRobusto(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.destreza += 2
        personagem.constituicao += 1
        println("Bonus Racial do Halfing Robusto Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Halfing Robusto";
    }
}
