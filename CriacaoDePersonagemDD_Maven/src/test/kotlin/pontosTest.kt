import Class.AnaoDaMontanha
import Class.Elfo
import Class.Humano
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import Func.Func

class PersonagemTest {

    // HashMap Para teste
    val niveisHashMap = HashMap<Int, Int>()


    val niveis = arrayOf(8, 9, 10, 11, 12, 13, 14, 15)
    val custos = arrayOf(0, 1, 2, 3, 4, 5, 7, 9)

    val funcao = Func();

//    @Test
//    fun testAtribuirPontosAnao() {
//        val anaoDaMontanha = AnaoDaMontanha(nome = "Farin", pontosDisponiveis = 27)
//
//        distribuirAtributos(anaoDaMontanha, niveisHashMap)
//
//        // Verificações
//        assertTrue(anaoDaMontanha.forca in 8..15)
//        assertTrue(anaoDaMontanha.destreza in 8..15)
//        assertTrue(anaoDaMontanha.constituicao in 8..15)
//        assertTrue(anaoDaMontanha.inteligencia in 8..15)
//        assertTrue(anaoDaMontanha.sabedoria in 8..15)
//        assertTrue(anaoDaMontanha.carisma in 8..15)
//    }

    @Test
    fun testAtribuirBonusAnao() {
        val anao = AnaoDaMontanha(
            nome = "farin",
            forca = 8,
            destreza = 8,
            constituicao = 8,
            inteligencia = 8,
            sabedoria = 8,
            carisma = 8
        )

        funcao.atribuirBonus(anao)

        // Valores esperados após aplicar o bônus
        val anaoForcaBonus = 10
        val anaoConstituicaoBonus = 10

        assertEquals(anaoForcaBonus, anao.forca, "Força deve ser 10")
        assertEquals(anaoConstituicaoBonus, anao.constituicao, "Constituição deve ser 10")
    }


    @Test
    fun testAtribuirBonusHumano() {
        val humano = Humano(
            nome = "eradan",
            forca = 8,
            destreza = 8,
            constituicao = 8,
            inteligencia = 8,
            sabedoria = 8,
            carisma = 8
        )

        funcao.atribuirBonus(humano)

        val ForcaBonus = 9
        val DestrezaBonus = 9
        val ConstituicaoBonus = 9
        val InteligenciaBonus = 9
        val SabedoriaBonus = 9
        val CarismaBonus = 9

        assertEquals(ForcaBonus, humano.forca, "Força deve ser 9")
        assertEquals(DestrezaBonus, humano.destreza, "destreza deve ser 9")
        assertEquals(ConstituicaoBonus, humano.constituicao, "Constituição deve ser 9")
        assertEquals(InteligenciaBonus, humano.sabedoria, "Inteligencia deve ser 9")
        assertEquals(SabedoriaBonus, humano.sabedoria, "Sabedoria deve ser 9")
        assertEquals(CarismaBonus, humano.carisma, "Carisma bonus deve ser 9")
    }
    @Test
    fun testAtribuirBonusElfo() {
        val elfo = Elfo(
            nome = "eradan",
            forca = 8,
            destreza = 8,
            constituicao = 8,
            inteligencia = 8,
            sabedoria = 8,
            carisma = 8
        )

        funcao.atribuirBonus(elfo)

        val DestrezaBonus = 10
        val InteligenciaBonus = 9
        val SabedoriaBonus = 9
        val CarismaBonus = 9

        assertEquals(DestrezaBonus, elfo.destreza, "Destreza deve ser 10")
        assertEquals(InteligenciaBonus, elfo.inteligencia, "Inteligência deve ser 9")
        assertEquals(SabedoriaBonus, elfo.sabedoria, "Sabedoria deve ser 9")
        assertEquals(CarismaBonus, elfo.carisma, "Carisma deve ser 9")
    }



}