package Class

class BonusAnao : Bonus<AnaoDaMontanha> {
    override fun recebeBonusClasse(anao: AnaoDaMontanha) {
        anao.forca += 2
        anao.constituicao += 2
    }
}