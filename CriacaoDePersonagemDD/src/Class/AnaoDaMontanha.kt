package Class

class AnaoDaMontanha(var bonus: Bonus,
                     private var nome: String,
                     var forca: Int = 8,
                     private var destreza: Int = 8,
                     private var constituicao: Int = 8,
                     private var inteligencia: Int = 8,
                     private var sabedoria: Int = 8,
                     private var carisma: Int = 8,
                     private var pontosDisponiveis: Int = 27) :
    Personagem(nome, forca, destreza, constituicao, inteligencia, sabedoria,carisma, pontosDisponiveis) {

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Montanha";
    }
}