enum class TipoCafe(val nombre: String) {
    con_leche("Con leche"),
    americano("Americano"),
    solo("Solo")
}

object CoffeeMachine {
    private const val dinero_min = 1.0

    private var estadoActual: CoffeeMachineState = CoffeeMachineState.Idle

    private var dinero = 0.0
    private var conAzucar = false
    private var descafeinado = false
    private var tipo: TipoCafe? = null

    fun iniciar() {
        if (estadoActual != CoffeeMachineState.Idle) {
            println("No se puede iniciar ahora. Estado actual: $estadoActual")
            return
        }

        println("Máquina disponible.")
        estadoActual = CoffeeMachineState.Monedero
        println("Inserta el dinero (minimo 1 €)")
    }

    fun insertarDinero(cantidad: Double) {
        if (estadoActual != CoffeeMachineState.Monedero) {
            println("No se puede insertar dinero ahora. Estado actual: $estadoActual")
            return
        }

        if (cantidad <= 0) {
            println("Cantidad no valida.")
            return
        }

        dinero += cantidad
        println("Dinero insertado: $dinero €")

        if (dinero >= dinero_min) {
            estadoActual = CoffeeMachineState.Azucar
            println("¿Quieres azucar? (true/false)")
        } else {
            println("Faltan ${dinero_min - dinero} € para empezar.")
        }
    }

    fun seleccionarAzucar (quiere: Boolean) {
        if (estadoActual != CoffeeMachineState.Azucar) {
            println("No se puede elegir azucar ahora. Estado actual: $estadoActual")
            return
        }

        conAzucar = quiere
        println(if (quiere) "Con azúcar." else "Sin azúcar.")
        estadoActual = CoffeeMachineState.Descafeinado
        println("¿Quieres el café descafeinado? (true / false) ")
    }

    fun seleccionarDescafeinado(quiere: Boolean) {
        if (estadoActual != CoffeeMachineState.Descafeinado) {
            println("No se puede elegir descafeinado ahora. Estado actual: $estadoActual")
            return
        }

        descafeinado = quiere
        println(if (quiere) "Descafeinado." else "Cafe normal.")
        estadoActual = CoffeeMachineState.Tipo
        println("¿Que tipo de cafe quieres? (con leche, americano o solo)")
    }

    fun seleccionarTipo(tipoElegido: TipoCafe) {
        if (estadoActual != CoffeeMachineState.Tipo) {
            println("No se puede elegir el tipo ahora. Estado actual: $estadoActual")
            return
        }

        tipo = tipoElegido
        println("Has elegido: ${tipoElegido.nombre}")
        estadoActual = CoffeeMachineState.Preparacion
        println("Deja el vaso en la maquina y llama a preparar()")
    }

    fun preparar() {
        if (estadoActual != CoffeeMachineState.Preparacion) {
            println("No se puede preparar ahora. Estado actual: $estadoActual")
            return
        }

        println("Preparando el cafe")
        try {
            Thread.sleep(2000)
            estadoActual = CoffeeMachineState.Entrega
            println("¡Cafe listo! Llama a recoger() para llevartelo.")
        } catch (excepcion: InterruptedException) {
            estadoActual = CoffeeMachineState.Error("La preparacion se interrumpio")
            println("Error: ${(estadoActual as CoffeeMachineState.Error).message}")
        }
    }

    fun recoger() {
        if (estadoActual != CoffeeMachineState.Entrega) {
            println("No se puede recoger ahora. Estado actual: $estadoActual")
            return
        }

        val azucar = if (conAzucar) "con azucar" else "sin azucar"
        val cafe = if (descafeinado) "descafeinado" else "normal"
        println("Entregado con exito | ${tipo?.nombre} ($cafe, $azucar)")

        reiniciar()
        estadoActual = CoffeeMachineState.Idle
    }

    fun limpiar() {
        println("Limpiando la maquina")
        reiniciar()
        estadoActual = CoffeeMachineState.Idle
        println("Maquina limpia. Estado: $estadoActual")
    }

    private fun reiniciar() {
        dinero = 0.0
        conAzucar = false
        descafeinado = false
        tipo = null
    }
}