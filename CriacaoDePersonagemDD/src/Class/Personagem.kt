package Class

open class Personagem(
    private var nome: String,
    private var forca: Int = 8,
    private var destreza: Int = 8,
    private var constituicao: Int = 8,
    private var inteligencia: Int = 8,
    private var sabedoria: Int = 8,
    private var carisma: Int = 8,
    private var pontosDisponiveis: Int = 27
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

    // Nome
    fun getNome(): String {
        return nome
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    // Forca

    fun getForca(): Int {
        return forca
    }

    fun setForca(forca: Int) {
        this.forca = forca
    }

    // Destreza

    fun getDestreza(): Int {
        return destreza
    }

    fun setDestreza(destreza: Int) {
        this.destreza = destreza
    }

    // Constituicao

    fun getConstituicao(): Int {
        return constituicao
    }

    fun setConstituicao(constituicao: Int) {
        this.constituicao = constituicao
    }

    // Inteligencia

    fun getInteligencia(): Int {
        return inteligencia
    }

    fun setInteligencia(inteligencia: Int) {
        this.inteligencia = inteligencia
    }

    //Sabedoria

    fun getSabedoria(): Int {
        return sabedoria
    }

    fun setSabedoria(sabedoria: Int) {
        this.sabedoria = sabedoria
    }

    // Carisma

    fun getCarisma(): Int {
        return carisma
    }

    fun setCarisma(carisma: Int) {
        this.carisma = carisma
    }

    // Pontos Disponiveis

    fun getPontosDisponiveis(): Int {
        return pontosDisponiveis
    }

    fun setPontosDisponiveis(pontosDisponiveis: Int) {
        this.pontosDisponiveis = pontosDisponiveis
    }
}