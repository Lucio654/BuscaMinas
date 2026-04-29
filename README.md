flowchart TB
    subgraph ACTORES
        direction TB
        A[JUGADOR]
        B[SISTEMA]
    end
    
    subgraph CASOS_DE_USO_JUGADOR
        C[Iniciar Nuevo Juego]
        D[Realizar Disparo]
        E[Ver Tableros]
        F[Consultar Estado]
        G[Salir del Juego]
    end
    
    subgraph CASOS_DE_USO_SISTEMA
        H[Colocar Barcos Automáticamente]
        I[Generar Disparo Computadora]
        J[Validar Disparo]
        K[Verificar Hundimiento]
        L[Determinar Ganador]
        M[Actualizar Interfaz]
    end
    
    A --> C
    A --> D
    A --> E
    A --> F
    A --> G
    
    B --> H
    B --> I
    B --> J
    B --> K
    B --> L
    B --> M
    
    C ==> H
    D ==> J
    J ==> K
    K ==> L
    K -.-> M
    L -.-> M
