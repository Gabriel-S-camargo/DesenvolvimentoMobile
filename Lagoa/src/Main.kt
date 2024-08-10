fun main(args: Array<String>) {
    var primeiroPato = Pato(VooComAsa());

    primeiroPato.fazerQuack();
    primeiroPato.boair();

    var patoBrabo = PatoBrabo(VooComAsa());

    patoBrabo.fazerQuack();
    patoBrabo.bicar();
}