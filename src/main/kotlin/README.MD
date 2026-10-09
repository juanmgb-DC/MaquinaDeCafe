#    MAQUINA DE CAFE

## PROCESO DE LA MAQUINA

----------------------------------------------------------------------------
1 - Idle: Estado inicial, en el que comprobamos si la maquina esta disponible o no.

2 - Monedero: Insertamos el dinero que tengamos a la maquina para empecar el proceso (minimo 1 euro)

3 - Azucar: Seleccionar si queremos azucar o no

4 - Descafeinado: Seleccionar si queremos que nuestro cafe sea descafeinado

5 - Tipo: Por ultimo, seleccionamos el tipo de cafe que queramos (Con leche, americano, solo)

6 - Preparacion: Dejamos el vaso en la maquina y nos preparar automaticamente el cafe

7 - Entrega: Una vez finalizado agarramos el vaso con nuestro cafe listo para tomar

----------------------------------------------------------------------------

## Diagrama de flujo

```mermaid
flowchart TD
    A([Inicio]) --> B[1. Idle<br/>Estado inicial]
    B --> C{¿Máquina<br/>disponible?}
    C -- No --> B
    C -- Sí --> D[2. Monedero<br/>Insertar dinero]
    D --> E{¿Dinero<br/>mínimo 1 €?}
    E -- No --> D
    E -- Sí --> F{3. Azúcar<br/>¿Quieres azúcar?}
    F -- Sí --> G[Con azúcar]
    F -- No --> H[Sin azúcar]
    G --> I{4. Descafeinado<br/>¿Quieres descafeinado?}
    H --> I
    I -- Sí --> J[Descafeinado]
    I -- No --> K[Normal]
    J --> L{5. Tipo<br/>¿Qué tipo de café?}
    K --> L
    L -- Con leche --> M1[Café con leche]
    L -- Americano --> M2[Café americano]
    L -- Solo --> M3[Café solo]
    M1 --> M[6. Preparación<br/>Colocar el vaso y<br/>preparar el café]
    M2 --> M
    M3 --> M
    M --> N[7. Entrega<br/>Recoger el vaso con el café]
    N --> O([Fin])
    O -.-> B
```


