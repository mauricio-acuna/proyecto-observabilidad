window.dashboardData = {
  projects: [
    {
      name: "01 Plataforma soporte bancario",
      status: "Compila + test",
      demonstrates: "Java/Spring, REST, eventos, auditoria, observabilidad",
      next: "PostgreSQL, Flyway, outbox real"
    },
    {
      name: "02 Observability control plane",
      status: "Compila + test",
      demonstrates: "OpenTelemetry, politicas, cardinalidad, collector",
      next: "Dashboards Grafana y SLOs"
    },
    {
      name: "03 Event-driven notification hub",
      status: "Compila + test",
      demonstrates: "Idempotencia, eventos, consumidores, adapters",
      next: "Broker real, retries y DLQ"
    },
    {
      name: "04 Secure API gateway identity",
      status: "Compila + test",
      demonstrates: "Gateway, JWT, OAuth2/OIDC, correlation id",
      next: "Keycloak y rate limiting"
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
      status: "Compila + test",
      demonstrates: "IA aplicada, structured outputs, prompt version",
      next: "Adapter LLM real y WireMock"
    }
  ],
  coverage: [
    ["Java/Spring backend", 100],
    ["Testing unitario", 70],
    ["Observabilidad", 55],
    ["Eventos e idempotencia", 45],
    ["Seguridad", 35],
    ["Cloud/AWS/FinOps", 35],
    ["IA aplicada", 35],
    ["Performance", 15]
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

