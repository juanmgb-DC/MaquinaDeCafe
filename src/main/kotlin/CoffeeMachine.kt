object CoffeeMachine {
    private var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun makeCoffee() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                println("Máquina encendida. Empezando a hacer café...")
                currentState = CoffeeMachineState.MakingCoffee
                Thread.sleep(2000)

                currentState = CoffeeMachineState.ServingCoffee("Nescafé")
                println("¡Café listo! Estado: $currentState")
            }

            is CoffeeMachineState.Monedero -> {
                println("Inserta el dinero (minimo 1$)")
            }

            is CoffeeMachineState.Azucar -> {
                println("Seleccione la cantidad de azucar que quiere")
            }

            is CoffeeMachineState.Descafeinado -> {
                println("Seleccione si quiere el cafe descafeinado")
            }

            is CoffeeMachineState.Tipo -> {
                println("Que tipo de cafe quiere")
            }

            is CoffeeMachineState.Preparacion -> {
                println("Preparando su cafe...")
            }

            is CoffeeMachineState.Entrega -> {
                print("Entregado con exito")
            }

            is CoffeeMachineState.MakingCoffee -> {
                println("¡Espera! La máquina ya está haciendo café.")
            }
            is CoffeeMachineState.ServingCoffee -> {
                println("Ya hay café servido. Por favor, toma tu café.")
            }
            is CoffeeMachineState.Error -> {
                println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message}")
            }
        }
    }

    fun clean() {
        println("Limpiando la máquina...")
        currentState = CoffeeMachineState.Idle
        println("Máquina limpia. Estado: $currentState")
    }
}

