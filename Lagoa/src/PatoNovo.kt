package VersaoComStrategy

open class PatoNovo(var voar: Voar) {

    fun voar(){
        this.voar.executaVoo()
    }

    open fun mudarEstiloDeVoo(novoVoo : Voar) {
        this.voar = novoVoo
    }

}