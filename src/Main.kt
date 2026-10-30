

fun main() {
    val numeroSecreto = (1..100).random()
    var intentos = 0
    var acertado = false

    println("=== ADIVINA EL NÚMERO ===")
    println("He pensado un número entre 1 y 100. ¡Intenta adivinarlo!")

    while (!acertado) {

        //solicita el número al usuario.
        print("Introduce un número entre 1 y 100: ")

        // readLine() devuelve String? (puede ser null).
        val entrada = readLine()
        val numero = entrada?.trim()?.toIntOrNull()

        //  validaciones
        if (numero == null) {
            // No se ha introducido un número entero válido.
            println("Error: debes introducir un número entero válido")

        } else if (numero < 1 || numero > 100) {
            // Rechaza negativos, el 0 y valores superiores a 100.
            println("Error: el número debe estar entre 1 y 100")

        } else {
            // El intento es válido: lo contamos (los errores no cuentan).
            intentos++

            // compara el intento con el número secreto.
            when {
                // Si el intento es mayor, el secreto es menor.
                numero > numeroSecreto -> println("El número secreto es menor.")

                // Si el intento es menor, el secreto es mayor.
                numero < numeroSecreto -> println("El número secreto es mayor.")

                else -> {
                    // Esto hará que el while termine.
                    acertado = true
                    println("¡Correcto! Has adivinado el número.")

                    val palabra = if (intentos == 1) "intento" else "intentos"
                    println("Has adivinado el número en $intentos $palabra")
                }
            }
        }
    }
}