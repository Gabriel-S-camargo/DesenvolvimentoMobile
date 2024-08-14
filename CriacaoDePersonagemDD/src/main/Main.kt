package main

import Class.AnaoDaMontanha
import Class.BonusAnao
import Class.Personagem
fun main() {
    val anao : AnaoDaMontanha = AnaoDaMontanha (BonusAnao(), "Farin");

    println(anao.toString());

    anao.bonus.recebeBonusClasse(anao)

    println(anao.toString());


}