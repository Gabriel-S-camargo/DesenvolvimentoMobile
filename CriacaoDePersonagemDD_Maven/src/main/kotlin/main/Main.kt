package main

import Class.AnaoDaMontanha
import Func.Func

fun main() {

    val niveisHashMap = HashMap<Int, Int>()


    val niveis = arrayOf(8, 9, 10, 11, 12, 13, 14, 15)
    val custos = arrayOf(0, 1, 2, 3, 4, 5, 7, 9)

    val funcao = Func()


    for (i in niveis.indices) {
        niveisHashMap[niveis[i]] = custos[i]
    }

   val personagem = funcao.menuStart()

    funcao.distribuirAtributos( personagem, niveisHashMap )

    funcao.atribuirBonus(personagem)

    println( personagem.toString())


}