package Class


import Interface.Bonus
import Class.AnaoDaMontanha
import Class.Personagem

class Humano : Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        personagem.forca +=1
        personagem.destreza +=1
        personagem.constituicao +=1
        personagem.inteligencia +=1
        personagem.sabedoria +=1
        personagem.carisma +=1
        println("Bonus Racial Do Humano Aplicado")
    }


    override fun toString(): String {
        return super.toString() + "\nClasse: Elfo";
    }

}