
sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()

    object Monedero : CoffeeMachineState()

    object Azucar : CoffeeMachineState()

    object Descafeinado : CoffeeMachineState()

    object Tipo : CoffeeMachineState()

    object Preparacion : CoffeeMachineState()

    object Entrega : CoffeeMachineState()

    object MakingCoffee : CoffeeMachineState()

    data class ServingCoffee(val brand: String) : CoffeeMachineState()

    data class Error(val message: String) : CoffeeMachineState()
}

