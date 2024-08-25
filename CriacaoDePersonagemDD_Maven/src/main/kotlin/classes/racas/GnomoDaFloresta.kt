package classes.racas

import classes.Personagem
import interface_.Bonus

class GnomoDaFloresta(nome: String) : Personagem(nome), Bonus {

    override fun recebeBonusRacial(personagem: Personagem) {
        personagem.destreza += 1
        println("Bonus Racial do Gnomo da Floresta Aplicado")
    }

    override fun toString(): String {
        return super.toString() + "\nClasse: Gnomo da Floresta"
    }
}
