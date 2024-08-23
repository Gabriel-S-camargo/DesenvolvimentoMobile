package classes.racas

import classes.Personagem
import interface_.Bonus

class ElfoDaFloresta(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.destreza += 2
        personagem.sabedoria += 1
        println("Bonus Racial do Elfo da Floresta Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Elfo da Floresta"
    }
}
