open class Pato (var voo : Voar){

    fun voarDeFato(){
        this.voo.executaVoo();
    }

    open fun fazerQuack(){
        println("Fazer quack");
    }

    open fun boair(){
        println("Estou Boaindo");
    }
}