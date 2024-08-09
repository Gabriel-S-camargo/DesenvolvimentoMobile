import java.util.Scanner
import kotlin.math.pow

fun calcularJurosCompostosSimples(principal: Double, taxa: Double, tempo: Int): Double {
    return principal * (1 + (taxa / 100) / 12).pow(12 * tempo)
}

fun calcularJurosCompostosMensais(inicial : Double, taxa: Double, tempo: Int, investimentoMensal: Double): Double {

    val juros = taxa / 100;

    var saldoTotal = inicial;

    for(mes in 1..tempo){
        saldoTotal += investimentoMensal;
        saldoTotal += saldoTotal * juros;
    }

    return saldoTotal
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Informe o valor principal (capital inicial): ")
    val principal = scanner.nextDouble()

    print("Informe a taxa de juros anual (em %): ")
    val rate = scanner.nextDouble()

    print("Informe o tempo de investimento (em anos): ")
    val time = scanner.nextInt()

    val montanteFinal = calcularJurosCompostosSimples(principal, rate, time)

    val jurosGanhos = montanteFinal - principal

    println("\nResultado do cálculo:")
    println("Valor investido: R$%.2f".format(principal))
    println("Juros compostos ganhos: R$%.2f".format(jurosGanhos))
    println("Montante final após $time anos: R$%.2f".format(montanteFinal))
}
