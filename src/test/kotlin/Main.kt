import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.BeforeTest
import CoffeeMachineState
import CoffeeMachine


fun main() {


    println("-- Inicio --")
    CoffeeMachine.iniciar()


    println("\n--- 2. Flujo Exitoso ---")
    CoffeeMachine.insertarDinero(1.5)
    CoffeeMachine.seleccionarAzucar(true)
    CoffeeMachine.seleccionarDescafeinado(false)
    CoffeeMachine.seleccionarTipo(tipoElegido = TipoCafe("Solo"))
    CoffeeMachine.preparar()
    CoffeeMachine.recoger()



}





}