graph TD
    %% Actores
    T[Técnico]
    C[Cliente]
    S[Sistema / Admin]

    %% Estilos de los Actores
    style T fill:#f9f,stroke:#333,stroke-width:2px
    style C fill:#f9f,stroke:#333,stroke-width:2px
    style S fill:#f9f,stroke:#333,stroke-width:2px

    subgraph "Sistema de Registro UCATEC"
        UC1((Registrar Perfil y Especialidad))
        UC2((Establecer Ubicación GPS))
        UC3((Buscar Técnico por Cercanía))
        UC4((Consultar Reputación Pública))
        UC5((Calificar Servicio Técnico))
        UC6((Ejecutar Fórmula de Haversine))
        UC7((Auditar Cambios en Calificaciones))
    end

    %% Conexiones
    T --- UC1
    T --- UC2
    
    C --- UC3
    C --- UC4
    C --- UC5

    S --- UC6
    S --- UC7

    %% Relaciones lógicas
    UC3 -.->|include| UC6
    UC5 -.->|include| UC7

    %% Estilos de los Casos de Uso (Óvalos)
    style UC1 fill:#fff,stroke:#002D62,stroke-width:2px
    style UC2 fill:#fff,stroke:#002D62,stroke-width:2px
    style UC3 fill:#fff,stroke:#002D62,stroke-width:2px
    style UC4 fill:#fff,stroke:#002D62,stroke-width:2px
    style UC5 fill:#fff,stroke:#002D62,stroke-width:2px
    style UC6 fill:#fff,stroke:#E31B23,stroke-width:2px
    style UC7 fill:#fff,stroke:#E31B23,stroke-width:2px
