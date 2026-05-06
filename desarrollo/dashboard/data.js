window.dashboardData = {
  projects: [
    {
      name: "01 Plataforma soporte bancario",
      status: "Persistencia + eventos",
      demonstrates: "Java/Spring, REST, PostgreSQL, outbox, RabbitMQ, observabilidad",
      next: "Validar integracion con Docker"
    },
    {
      name: "02 Observability control plane",
      status: "Stack observable",
      demonstrates: "OpenTelemetry, Tempo, Prometheus, Grafana, SLI/SLO, runbooks",
      next: "Validar trazas end-to-end"
    },
    {
      name: "03 Event-driven notification hub",
      status: "Eventos + DLQ",
      demonstrates: "Idempotencia, RabbitMQ, retry, DLQ, metricas operativas",
      next: "Validar flujo completo con Docker"
    },
    {
      name: "04 Secure API gateway identity",
      status: "Gateway seguro",
      demonstrates: "Gateway, JWT, OAuth2/OIDC, Redis rate limiting, 401/403/429",
      next: "Validar end-to-end con Keycloak"
    },
    {
      name: "05 FinOps cloud cost guardian",
      status: "Compila + test",
      demonstrates: "Costos cloud, recomendaciones, integracion externa",
      next: "AWS Cost Explorer real"
    },
    {
      name: "06 RAG knowledge assistant",
      status: "Compila + test",
      demonstrates: "RAG, vector search, LLM port, evidencia",
      next: "pgvector/Qdrant y evaluacion"
    },
    {
      name: "07 Incident response runbook system",
      status: "Compila + test",
      demonstrates: "Incidentes, severidad, operacion, MTTR",
      next: "Runbooks, postmortems, SLOs"
    },
    {
      name: "08 Payment risk monitoring",
      status: "Compila + test",
      demonstrates: "Reglas, auditoria, riesgo financiero",
      next: "Eventos y metricas de falsos positivos"
    },
    {
      name: "09 Batch reporting modernization",
      status: "Compila + test",
      demonstrates: "Batch, validacion, staging/rechazo",
      next: "Reader/processor/writer real"
    },
    {
      name: "10 Platform engineering template",
      status: "Compila + test",
      demonstrates: "Golden path, CI, Docker, Kubernetes",
      next: "Guia de generacion de servicios"
    },
    {
      name: "11 Modular monolith to microservices",
      status: "Compila + test",
      demonstrates: "Modularidad, API interna, migracion gradual",
      next: "Eventos internos y plan de extraccion"
    },
    {
      name: "12 AI ticket triage service",
      status: "Adapter IA externo",
      demonstrates: "IA aplicada, structured outputs, prompt version, fallback, costo/tokens, redaccion",
      next: "Pruebas de contrato WireMock"
    }
  ],
  coverage: [
    ["Java/Spring backend", 100],
    ["Testing unitario", 70],
    ["Observabilidad", 75],
    ["Eventos e idempotencia", 65],
    ["Seguridad", 55],
    ["Cloud/AWS/FinOps", 35],
    ["IA aplicada", 55],
    ["Performance", 25]
  ],
  sprints: [
    ["Sprint 1", "Estabilizar build, JDK 21, JaCoCo y Docker Compose minimo."],
    ["Sprint 2", "PostgreSQL, Flyway, Testcontainers y outbox en proyecto 01."],
    ["Sprint 3", "Broker real, retries, DLQ e integracion con notification hub."],
    ["Sprint 4", "OpenTelemetry Collector, dashboards, SLI/SLO y runbooks."],
    ["Sprint 5", "Keycloak, JWT, rate limiting y tests de seguridad."],
    ["Sprint 6", "k6, baseline p95 y reporte de performance."],
    ["Sprint 7", "Adapters IA reales, WireMock, tokens, costo y guardrails."]
  ]
};
