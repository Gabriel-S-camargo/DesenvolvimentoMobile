package Class

class AnaoDaMontanha(
    override var nome: String,
    override var forca: Int = 8,
    override var destreza: Int = 8,
    override var constituicao: Int = 8,
    override var inteligencia: Int = 8,
    override var sabedoria: Int = 8,
    override var carisma: Int = 8,
    override var pontosDisponiveis: Int = 27
) :
    Personagem(nome, forca, destreza, constituicao, inteligencia, sabedoria, carisma, pontosDisponiveis) {

    override fun toString(): String {
        return super.toString() + "\nClasse: Anão da Montanha";
    }
}