package Func

// Para funcionar isso aqui precisa puxar uma library :
// passo a passo : Go to File >
//                 Project Structure >
//                 Libraries > New Project Library >
//                 From Maven Repository >
//                 Search for "kotlin-reflect" and add the correct version from the results

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties
import Racas.*

class Func {

    fun HashMapNiveis(): HashMap<Int, Int> {

        val niveisHashMap = HashMap<Int, Int>()

        val niveis = arrayOf(8, 9, 10, 11, 12, 13, 14, 15)
        val custos = arrayOf(0, 1, 2, 3, 4, 5, 7, 9)

        for (i in niveis.indices) {
            niveisHashMap[niveis[i]] = custos[i]
        }

        return niveisHashMap
    }

    fun personagemStatus(personagem: Personagem) {
        println(personagem.toString())
    }

    fun menuClasses() {
        println("[1] Anão da Montanha   [2] Humano        [3] Elfo")
        println("[4] Draconato          [5] Meio-Orc      [6] Halfing")
        println("[7] Gnomo da Floresta  [8] Anão          [9] Halfing Robusto")
        println("[10] Gnomo das Rochas  [11] Gnomo        [12] Alto Elfo")
        println("[13] Anão da Colina    [14] Tielfling    [15] Elfo da Floresta")
        println("[16] Meio-Elfo         [17] Drow         [18] Halfing Pés-Leves")
    }

    fun menuStart(): Personagem {


        println("Bem-vindo ao Criador de Personagem D & D")
        println("Escolha a Raca do seu personagem:")
        menuClasses()

        var opcaoClasse: Int? = readLine()?.toIntOrNull()

        // Validação da opção de classe
        if (opcaoClasse == null || opcaoClasse !in 1..18) {
            println("Opção Inválida! Classe Atribuída: Anão da Montanha")
            opcaoClasse = 1
        }

        println("Escolha o nome do personagem:")
        var nomeClasse: String = readLine().orEmpty()

        if (nomeClasse.isBlank()) {
            println("Nome inválido! Nome Atribuído: Farin")
            nomeClasse = "Farin"
        }

        // Retornando a classe de acordo com a escolha do usuário
        return when (opcaoClasse) {
            1  -> AnaoDaMontanha(nome = nomeClasse)
            2  -> Humano(nome = nomeClasse)
            3  -> Elfo(nome = nomeClasse)
            4  -> Draconato(nome = nomeClasse)
            5  -> MeioOrc(nome = nomeClasse)
            6  -> Halfing(nome = nomeClasse)
            7  -> GnomoDaFloresta(nome = nomeClasse)
            8  -> Anao(nome = nomeClasse)
            9  -> HalfingRobusto(nome = nomeClasse)
            10 -> GnomoDasRochas(nome = nomeClasse)
            11 -> Gnomo(nome = nomeClasse)
            12 -> AltoElfo(nome = nomeClasse)
            13 -> AnaoDaColina(nome = nomeClasse)
            14 -> Tiefling(nome = nomeClasse)
            15 -> ElfoDaFloresta(nome = nomeClasse)
            16 -> MeioElfo(nome = nomeClasse)
            17 -> Drow(nome = nomeClasse)
            18 -> HalfingPesLeves(nome = nomeClasse)
            else -> AnaoDaMontanha(nome = nomeClasse)  // Caso inválido, retorna Anão da Montanha
        }

    }


    fun distribuirAtributos(personagem: Personagem, hashmap: HashMap<Int, Int>) {
        // Ajuste de declaredMemberProperties para apenas memberProperties,
        // que faz com que atributos herdados sejam acessados
        val properties = personagem::class.memberProperties

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
                        nivelTemp = 8
                        @Suppress("UNCHECKED_CAST")
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
                            println("Pontos Restantes: " + personagem.pontosDisponiveis)
                            pontosValidos = true // Nível atribuído com sucesso, sair do loop
                        } else {
                            println("Pontos insuficientes! Pontos Disponíveis: ${personagem.pontosDisponiveis}")
                            println("Deseja reatribuir nível (y/n)? (Caso seja não, nível 8 será atribuído)")
                            val opcaoPontos = readLine().orEmpty()

                            if (opcaoPontos.lowercase() == "n") {
                                nivelTemp = 8
                                @Suppress("UNCHECKED_CAST")
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
            is AnaoDaMontanha -> personagem.recebeBonusClasse(personagem)
            is Humano -> personagem.recebeBonusClasse(personagem)
            is Elfo -> personagem.recebeBonusClasse(personagem)
            is Draconato -> personagem.recebeBonusClasse(personagem)
            is MeioOrc -> personagem.recebeBonusClasse(personagem)
            is Halfing -> personagem.recebeBonusClasse(personagem)
            is GnomoDaFloresta -> personagem.recebeBonusClasse(personagem)
            is Anao -> personagem.recebeBonusClasse(personagem)
            is HalfingRobusto -> personagem.recebeBonusClasse(personagem)
            is GnomoDasRochas -> personagem.recebeBonusClasse(personagem)
            is Gnomo -> personagem.recebeBonusClasse(personagem)
            is AltoElfo -> personagem.recebeBonusClasse(personagem)
            is AnaoDaColina -> personagem.recebeBonusClasse(personagem)
            is Tiefling -> personagem.recebeBonusClasse(personagem)
            is HalfingPesLeves -> personagem.recebeBonusClasse(personagem)
            is Drow -> personagem.recebeBonusClasse(personagem)
            is MeioElfo -> personagem.recebeBonusClasse(personagem)
            is ElfoDaFloresta -> personagem.recebeBonusClasse(personagem)
            else -> println("Classe desconhecida! Nenhum bônus aplicado.")
        }
    }

}