package Class

open class Personagem(
    open var nome: String,
    open var forca: Int = 8,
    open var destreza: Int = 8,
    open var constituicao: Int = 8,
    open var inteligencia: Int = 8,
    open var sabedoria: Int = 8,
    open var carisma: Int = 8,
    open var pontosDisponiveis: Int = 27
) {

    override fun toString(): String {
        return  "Nome: " + nome +
                "\nForca: " + forca.toString() +
                "\nDestreza: " + destreza.toString() +
                "\nConstituicao: " + constituicao.toString() +
                "\nInteligencia: " + inteligencia.toString() +
                "\nSabedoria: " + sabedoria.toString() +
                "\nCarisma: " + carisma.toString() +
                "\nPontosDisponiveis: " + pontosDisponiveis.toString()
    }
    // Get's e Setter's


}