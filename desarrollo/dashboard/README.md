# Dashboard del proyecto

Este dashboard es una pagina estatica para mostrar el estado actual de la cartera `desarrollo`.

## Abrir

Abrir en el navegador:

```text
desarrollo/dashboard/index.html
```

## Que muestra

- Estado de build y tests.
- Proyectos compilados.
- Tests actuales.
- Cobertura del stack profesional.
- Dolor tecnico visible.
- Deuda tecnica.
- Roadmap de sprints.
- Estado por proyecto.

## Fuente

Los datos reflejan el estado validado con:

```bash
gradle clean test jacocoTestReport --console=plain
```

Resultado:

```text
BUILD SUCCESSFUL
69 actionable tasks: 67 executed, 2 up-to-date
```
