package VersaoComStrategy

class PatoNovoBorracha(voar : VoarNoWay) : PatoNovo(voar) {

    // polimorfismo 'engessando' o estilo de novo
    override fun mudarEstiloDeVoo(novoVoo: Voar) {
        println("não posso mudar estilo de voo")
    }
}