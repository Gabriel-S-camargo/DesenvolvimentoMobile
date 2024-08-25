import func.Func

fun main() {

    val funcao = Func()

    val niveisHashMap = funcao.hashMapNiveis()

    val personagem = funcao.menuStart()

    funcao.distribuirAtributos(personagem, niveisHashMap)

    funcao.atribuirBonus(personagem)

    funcao.atribuirVida(personagem)

    funcao.atribuirModificadores(personagem)

    funcao.personagemStatus(personagem)


}