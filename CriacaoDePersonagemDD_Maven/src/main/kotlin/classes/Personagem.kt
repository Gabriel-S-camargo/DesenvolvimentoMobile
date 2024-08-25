package classes

open class Personagem(var nome : String? = null) {
     var forca: Int = 8
     var destreza: Int = 8
     var constituicao: Int = 8
     var inteligencia: Int = 8
     var sabedoria: Int = 8
     var carisma: Int = 8
     var vida = 10
     var pontosDisponiveis: Int = 27
     var modificadores = HashMap<String, Int>()

    override fun toString(): String {
        return "Nome: " + nome +
                "\nForca: " + forca.toString() +
                "  Mod: " + modificadores["forca"] +
                "\nDestreza: " + destreza.toString() +
                "  Mod: " + modificadores["destreza"] +
                "\nConstituicao: " + constituicao.toString() +
                "  Mod: " + modificadores["constituicao"] +
                "\nInteligencia: " + inteligencia.toString() +
                "  Mod: " + modificadores["inteligencia"] +
                "\nSabedoria: " + sabedoria.toString() +
                "  Mod: " + modificadores["sabedoria"] +
                "\nCarisma: " + carisma.toString() +
                "  Mod: " + modificadores["carisma"] +
                "\nPontosDisponiveis: " + pontosDisponiveis.toString() +
                "\nVida: " + vida.toString()
    }
}



