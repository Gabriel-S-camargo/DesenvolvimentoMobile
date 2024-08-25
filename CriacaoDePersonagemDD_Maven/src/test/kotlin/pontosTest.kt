import classes.racas.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import func.Func

class PersonagemTest {
    val funcao = Func()

    @Test
    fun testAtribuirBonusAltoElfo() {
        val altoElfo = AltoElfo(nome = "Farin")

        funcao.atribuirBonus(altoElfo)

        val inteligenciaBonus = 9

        assertEquals(inteligenciaBonus, altoElfo.inteligencia, "Inteligência deve ser 9")
    }

    @Test
    fun testAtribuirBonusAnao() {
        val anao = Anao(nome = "Farin")

        funcao.atribuirBonus(anao)

        val constituicaoBonus = 10

        assertEquals(constituicaoBonus, anao.constituicao, "Constituição deve ser 10")
    }

    @Test
    fun testAtribuirBonusAnaoDaColina() {
        val anaoDaColina = AnaoDaColina(nome = "Farin")

        funcao.atribuirBonus(anaoDaColina)

        val sabedoriaBonus = 9

        assertEquals(sabedoriaBonus, anaoDaColina.sabedoria, "Sabedoria deve ser 9")
    }

    @Test
    fun testAtribuirBonusAnaoDaMontanha() {
        val anao = AnaoDaMontanha(nome = "Farin")

        funcao.atribuirBonus(anao)

        val anaoForcaBonus = 10

        assertEquals(anaoForcaBonus, anao.forca, "Força deve ser 10")
    }

    @Test
    fun testAtribuirBonusDraconato() {
        val draconato = Draconato(nome = "Farin")

        funcao.atribuirBonus(draconato)

        val forcaBonus = 10
        val carismaBonus = 9

        assertEquals(forcaBonus, draconato.forca, "Força deve ser 10")
        assertEquals(carismaBonus, draconato.carisma, "Carisma deve ser 9")
    }

    @Test
    fun testAtribuirBonusDrow() {
        val drow = Drow(nome = "Farin")

        funcao.atribuirBonus(drow)

        val carismaBonus = 9

        assertEquals(carismaBonus, drow.carisma, "Carisma deve ser 9")
    }

    @Test
    fun testAtribuirBonusElfo() {
        val elfo = Elfo(nome = "Farin")

        funcao.atribuirBonus(elfo)

        val DestrezaBonus = 10

        assertEquals(DestrezaBonus, elfo.destreza, "Destreza deve ser 10")

    }

    @Test
    fun testAtribuirBonusElfoDaFloresta() {
        val elfoDaFloresta = ElfoDaFloresta(nome = "Farin")

        funcao.atribuirBonus(elfoDaFloresta)

        val sabedoriaBonus = 9

        assertEquals(sabedoriaBonus, elfoDaFloresta.sabedoria, "Sabedoria deve ser 9")
    }

    @Test
    fun testAtribuirBonusGnomo() {
        val gnomo = Gnomo(nome = "Farin")

        funcao.atribuirBonus(gnomo)

        val inteligenciaBonus = 10

        assertEquals(inteligenciaBonus, gnomo.inteligencia, "Inteligência deve ser 10")
    }

    @Test
    fun testAtribuirBonusGnomoDaFloresta() {
        val gnomoDaFloresta = GnomoDaFloresta(nome = "Farin")

        funcao.atribuirBonus(gnomoDaFloresta)

        val destrezaBonus = 9


        assertEquals(destrezaBonus, gnomoDaFloresta.destreza, "Destreza deve ser 9")

    }

    @Test
    fun testAtribuirBonusGnomoDasRochas() {
        val gnomoDasRochas = GnomoDasRochas(nome = "Farin")

        funcao.atribuirBonus(gnomoDasRochas)

        val constituicaoBonus = 9

        assertEquals(constituicaoBonus, gnomoDasRochas.constituicao, "Constituição deve ser 9")
    }

    @Test
    fun testAtribuirBonusHalfing() {
        val halfing = Halfing(nome = "Farin")

        funcao.atribuirBonus(halfing)

        val destrezaBonus = 10

        assertEquals(destrezaBonus, halfing.destreza, "Destreza deve ser 10")
    }

    @Test
    fun testAtribuirBonusHalfingPesLeves() {
        val halfingPesLeves = HalfingPesLeves(nome = "Farin")

        funcao.atribuirBonus(halfingPesLeves)

        val carismaBonus = 9

        assertEquals(carismaBonus, halfingPesLeves.carisma, "Carisma deve ser 9")
    }

    @Test
    fun testAtribuirBonusHalfingRobusto() {
        val halfingRobusto = HalfingRobusto(nome = "Farin")

        funcao.atribuirBonus(halfingRobusto)

        val constituicaoBonus = 9

        assertEquals(constituicaoBonus, halfingRobusto.constituicao, "Constituição deve ser 9")
    }


    @Test
    fun testAtribuirBonusHumano() {
        val humano = Humano(nome = "Farin")

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
    fun testAtribuirBonusMeioElfo() {
        val meioElfo = MeioElfo(nome = "Farin")

        funcao.atribuirBonus(meioElfo)

        val carismaBonus = 10

        assertEquals(carismaBonus, meioElfo.carisma, "Carisma deve ser 10")
    }


    @Test
    fun testAtribuirBonusMeioOrc() {
        val meioOrc = MeioOrc(nome = "Farin")

        funcao.atribuirBonus(meioOrc)

        val forcaBonus = 10
        val constituicaoBonus = 9

        assertEquals(forcaBonus, meioOrc.forca, "Força deve ser 10")
        assertEquals(constituicaoBonus, meioOrc.constituicao, "Constituição deve ser 9")
    }


    @Test
    fun testAtribuirBonusTielfling() {
        val tiefling = Tiefling(nome = "Farin")

        funcao.atribuirBonus(tiefling)

        val inteligenciaBonus = 9
        val carismaBonus = 10

        assertEquals(inteligenciaBonus, tiefling.inteligencia, "Inteligência deve ser 9")
        assertEquals(carismaBonus, tiefling.carisma, "Carisma deve ser 10")
    }

    @Test
    fun testAtribuirVida(){

        val anaoVida = Anao(nome = "Farin")

        anaoVida.constituicao = 15

        funcao.atribuirBonus(anaoVida)

        funcao.atribuirVida(anaoVida)

        val anaoVidaFinal = 13

        assertEquals(anaoVidaFinal, anaoVida.vida, "Vida deve ser 13")
    }


}