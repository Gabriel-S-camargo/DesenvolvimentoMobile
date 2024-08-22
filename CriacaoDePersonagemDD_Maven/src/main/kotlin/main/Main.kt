package main

import Class.Personagem
import Func.Func

fun main() {

    val funcao = Func()

    val niveisHashMap = funcao.HashMapNiveis()

    val personagem = funcao.menuStart()

    funcao.distribuirAtributos( personagem, niveisHashMap )

    funcao.atribuirBonus(personagem)

    funcao.personagemStatus(personagem)


}