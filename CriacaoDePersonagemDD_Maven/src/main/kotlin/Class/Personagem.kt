package Class

import Interface.Bonus

open class Personagem {

     var nome : String? = null
     var forca: Int = 8
     var destreza: Int = 8
     var constituicao: Int = 8
     var inteligencia: Int = 8
     var sabedoria: Int = 8
     var carisma: Int = 8
     var pontosDisponiveis: Int = 27


    override fun toString(): String {
        return "Nome: " + nome +
                "\nForca: " + forca.toString() +
                "\nDestreza: " + destreza.toString() +
                "\nConstituicao: " + constituicao.toString() +
                "\nInteligencia: " + inteligencia.toString() +
                "\nSabedoria: " + sabedoria.toString() +
                "\nCarisma: " + carisma.toString() +
                "\nPontosDisponiveis: " + pontosDisponiveis.toString()
    }
}



