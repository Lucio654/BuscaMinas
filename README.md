
```mermaid
classDiagram
    direction TD
    
    %% Nivel 1: Entidades Principales
    class Tecnico {
        +int tecnicoID
        +string nombreCompleto
        +string especialidad
        +decimal latitud
        +decimal longitud
        +bit activo
        +actualizarUbicacion(lat, lng)
        +obtenerPerfilPublico()
    }

    class Cliente {
        +int clienteID
        +string nombreCompleto
        +string telefono
        +buscarCercanos(radioKm)
        +calificarTecnico(trabajoID, puntos)
    }

    %% Nivel 2: Operación
    class Trabajo {
        +int trabajoID
        +date fecha
        +string estado
        +finalizarTrabajo()
    }

    %% Nivel 3: Feedback y Control
    class Calificacion {
        +int calificacionID
        +int puntaje
        +string comentario
        +notificarTriggerAuditoria()
    }

    class LogAuditoria {
        +int logID
        +datetime fechaAccion
        +string cambioAnterior
        +string cambioNuevo
    }

    %% Relaciones Jerárquicas (Flujo de arriba hacia abajo)
    Tecnico "1" -- "*" Trabajo : realiza
    Cliente "1" -- "*" Trabajo : solicita
    Trabajo "1" -- "1" Calificacion : genera
    Calificacion ..> LogAuditoria : activa trigger

    %% Conexiones invisibles para forzar el orden si GitHub lo desordena
    Tecnico ~~~ Calificacion
    Cliente ~~~ Calificacion


```
