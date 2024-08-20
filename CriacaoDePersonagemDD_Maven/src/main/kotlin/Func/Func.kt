package Func

// Para funcionar isso aqui precisa puxar uma library :
// passo a passo : Go to File >
//                 Project Structure >
//                 Libraries > New Project Library >
//                 From Maven Repository >
//                 Search for "kotlin-reflect" and add the correct version from the results

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.declaredMemberProperties
import Class.AnaoDaMontanha
import Class.Elfo
import Class.Humano
import Class.Personagem

class Func {

    fun menuClasses() {
        println("[1] Anao Da Montanha")
        println("[2] Humano")
        println("[3] Elfo")
    }

    fun menuStart(): Personagem {
        println("Bem Vindo ao Criador de Personagem D & D")
        println("Escolha a Classe do seu personagem:")
        menuClasses()

        var opcaoClasse: Int? = readLine()?.toIntOrNull()

        if (opcaoClasse == null || opcaoClasse !in 1..3) {
            println("Caracter Inválido! Classe Atribuida : Anão da Montanha")
            opcaoClasse= 1;
        }

        println("Escolha o nome do personagem:")
        var nomeClasse: String = readLine().orEmpty()

        if (nomeClasse.isBlank()) {
            when (opcaoClasse) {
                1 -> {
                    println("Caracter inválido! Nome Atribuido: Farin")
                    nomeClasse = "Farin"
                }
                2 -> {
                    println("Caracter inválido! Nome Atribuido: Eradan")
                    nomeClasse = "Eradan"
                }
                3 -> {
                    println("Caracter inválido! Nome Atribuido: Andriel")
                    nomeClasse = "Andriel"
                }
            }
        }

        return when (opcaoClasse) {
            1 -> AnaoDaMontanha(nome = nomeClasse, pontosDisponiveis = 27)
            2 -> Humano(nome =nomeClasse, pontosDisponiveis = 27)
            3 -> Elfo(nome = nomeClasse, pontosDisponiveis = 27)
            else -> AnaoDaMontanha(nome =nomeClasse, pontosDisponiveis = 27)
        }
    }

    fun distribuirAtributos(personagem: Personagem, hashmap: HashMap<Int, Int>) {
        val properties = personagem::class.declaredMemberProperties

        properties.forEach { property ->

            if (property.name == "pontosDisponiveis") {
                return@forEach
            }

            if (property is KMutableProperty1<*, *> && property.returnType.classifier == Int::class) {
                var nivelTemp: Int? = null
                var pontosValidos = false

                do {
                    println("Qual o nível você deseja para ${property.name}? (Entre 8 e 15)")
                    nivelTemp = readLine()?.toIntOrNull()

                    if (nivelTemp == null || nivelTemp !in 8..15) {
                        println("Entrada inválida! Nível base para ${property.name} atribuído: 8")
                        @Suppress("UNCHECKED_CAST")
                        nivelTemp = 8
                        (property as KMutableProperty1<Personagem, Int>).setter.call(personagem, nivelTemp)
                        pontosValidos = true
                    } else {
                        val pontosUtilizados: Int? = hashmap[nivelTemp]
                        val pontosDisponiveis: Int = personagem.pontosDisponiveis

                        if (pontosUtilizados != null && pontosUtilizados <= pontosDisponiveis) {
                            println("Pontos Disponiveis: " + personagem.pontosDisponiveis)
                            println("Pontos Utilizados: " + pontosUtilizados)
                            personagem.pontosDisponiveis -= pontosUtilizados
                            @Suppress("UNCHECKED_CAST")
                            (property as KMutableProperty1<Personagem, Int>).setter.call(personagem, nivelTemp)
                            pontosValidos = true // Nível atribuído com sucesso, sair do loop
                        } else {
                            println("Pontos insuficientes! Pontos Disponíveis: ${personagem.pontosDisponiveis}")
                            println("Deseja reatribuir nível (y/n)? (Caso seja não, nível 8 será atribuído)")
                            val opcaoPontos = readLine().orEmpty()

                            if (opcaoPontos.lowercase() == "n") {
                                @Suppress("UNCHECKED_CAST")
                                nivelTemp = 8
                                (property as KMutableProperty1<Personagem, Int>).setter.call(personagem, nivelTemp)
                                pontosValidos = true // Para sair do loop
                            }
                        }
                    }
                } while (!pontosValidos)

                println("${property.name} atualizado para $nivelTemp\n")
            }
        }
    }

    fun atribuirBonus(personagem: Personagem) {
        when (personagem) {
            is AnaoDaMontanha -> {
                personagem.forca += 2
                personagem.constituicao += 2
                println("Bônus de Classe Anão Aplicado!!\nForça +2 e Constituição +2")
            }

            is Elfo -> {
                personagem.destreza += 2
                personagem.inteligencia += 1
                personagem.sabedoria += 1
                personagem.carisma += 1
                println("Bônus de Classe Elfo Aplicado!!\nForça +2 e Constituição +2")
            }

            is Humano -> {
                personagem.forca +=1
                personagem.destreza +=1
                personagem.constituicao +=1
                personagem.inteligencia +=1
                personagem.sabedoria +=1
                personagem.carisma +=1

                println("Bônus de Classe Humano Aplicado!!\nForça +2 e Constituição +2")
            }
        }
    }
}