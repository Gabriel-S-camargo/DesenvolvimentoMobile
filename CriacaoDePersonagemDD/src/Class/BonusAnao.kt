package Class

final class BonusAnao : Bonus {

    override fun recebeBonusClasse(personagem: Personagem) {
        var forca = personagem.getForca()
        println("Anao forte + 2");
    }
}