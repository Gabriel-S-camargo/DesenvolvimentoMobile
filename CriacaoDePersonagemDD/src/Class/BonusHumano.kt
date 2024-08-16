package Class

class BonusHumano : Bonus<Humano> {

    override fun recebeBonusClasse(humano: Humano) {
        humano.forca+2
        println("Anao Força + 2");

        humano.constituicao+2
        println("Anao Constituicao + 2");
    }
}