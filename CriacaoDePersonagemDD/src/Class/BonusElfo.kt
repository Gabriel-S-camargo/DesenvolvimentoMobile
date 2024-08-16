package Class

class BonusElfo : Bonus<Elfo> {

    override fun recebeBonusClasse(elfo: Elfo) {
        elfo.forca+2
        println("Anao Força + 2");

        elfo.constituicao+2
        println("Anao Constituicao + 2");
    }
}