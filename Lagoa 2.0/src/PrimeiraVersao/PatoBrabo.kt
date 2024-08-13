package PrimeiraVersao

class PatoBrabo : Pato(){

    // pato com nova ação
    fun bicar(){
        println("te biquei!")
    }

    // polimorfismo
    override fun quack(){
        println("QUAAACK")
    }
}