package VersaoComStrategy

open class Hunter(var voar : VoarComFoguete, var som : EmitirSom){

    fun voar(){
        this.voar.executaVoo();
    }

    fun imitarSom(){
        this.som.emiteSom();
    }

    fun atirar(){
        println("BANGGGG")
    }
}