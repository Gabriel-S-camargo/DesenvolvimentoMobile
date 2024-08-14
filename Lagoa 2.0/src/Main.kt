import PrimeiraVersao.Pato
import PrimeiraVersao.PatoBorracha
import PrimeiraVersao.PatoBrabo
import VersaoComStrategy.*

fun main() {

//    val patoNovo : PatoNovo = PatoNovo(VoarComAsas())
//    patoNovo.voar() // enviamos voar com asas
//    // mudamos o estilo de voo em tempo de execução:
//    patoNovo.mudarEstiloDeVoo(VoarComFoguete())
//    patoNovo.voar() // pato a jato
//
//    // o novo de borracha só aceita VoarNoWay no envio
//    val patoNovoDeBorracha = PatoNovoBorracha(VoarNoWay());
//    patoNovoDeBorracha.voar()
//    // 'engessamos' o estilo de voo mesmo em tempo de execução
//    patoNovoDeBorracha.mudarEstiloDeVoo(VoarComFoguete())
//    patoNovoDeBorracha.voar()

    val cacador : Hunter = Hunter(VoarComFoguete(), Quack());

    cacador.voar();
    cacador.imitarSom();
    cacador.atirar();

}

