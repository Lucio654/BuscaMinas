```mermaid

graph TD
    %% Definición de Actores
    subgraph Actores
        T((Técnico))
        C((Cliente))
        S((Sistema / Database))
    end

    %% Límites del Sistema
    subgraph "Registro de Empleo Informal y Servicios Técnicos"
        UC1(Registrar Perfil y Ubicación)
        UC2(Gestionar Especialidades)
        UC3(Consultar Técnicos por Cercanía)
        UC4(Visualizar Perfil Público Seguro)
        UC5(Registrar Trabajo Realizado)
        UC6(Calificar Servicio / Reputación)
        UC7(Auditar Cambios en Calificaciones)
    end

    %% Relaciones del Técnico
    T --> UC1
    T --> UC2
    T --> UC4

    %% Relaciones del Cliente
    C --> UC1
    C --> UC3
    C --> UC4
    C --> UC6

    %% Relaciones del Sistema (Lógica Interna)
    UC3 -.->|Usa Haversine| S
    UC6 -.->|Dispara| UC7
    S --- UC7

```
