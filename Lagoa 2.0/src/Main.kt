import PrimeiraVersao.Pato
import PrimeiraVersao.PatoBorracha
import PrimeiraVersao.PatoBrabo
import VersaoComStrategy.*

fun main() {

    // primeira versão, o pato de borracha está voando!
    val meuPato : Pato = Pato()
    meuPato.quack()
    val patoBorracha : PatoBorracha = PatoBorracha()
    patoBorracha.quack() // consegue fazer quack pois herda de Pato
    patoBorracha.voar() // assim como voar, o que nosso cliente não quer
    val patoDonald = PatoBrabo()
    patoDonald.quack() // 'quackareja' diferente!
    patoDonald.bicar() // consegue bicar

    // nova versão com strategy
    val patoNovo : PatoNovo = PatoNovo(VoarComAsas())
    patoNovo.voar() // enviamos voar com asas
    // mudamos o estilo de voo em tempo de execução:
    patoNovo.mudarEstiloDeVoo(VoarComFoguete())
    patoNovo.voar() // pato a jato

    // o novo de borracha só aceita VoarNoWay no envio
    val patoNovoDeBorracha = PatoNovoBorracha(VoarNoWay());
    patoNovoDeBorracha.voar()
    // 'engessamos' o estilo de voo mesmo em tempo de execução
    patoNovoDeBorracha.mudarEstiloDeVoo(VoarComFoguete())
    patoNovoDeBorracha.voar()

}

