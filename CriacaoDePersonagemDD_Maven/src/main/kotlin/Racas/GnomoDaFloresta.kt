package Racas

import Interface.Bonus

class GnomoDaFloresta(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.destreza += 1
        personagem.inteligencia += 2
        println("Bonus Racial do Gnomo da Floresta Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Gnomo da Floresta";
    }
}
