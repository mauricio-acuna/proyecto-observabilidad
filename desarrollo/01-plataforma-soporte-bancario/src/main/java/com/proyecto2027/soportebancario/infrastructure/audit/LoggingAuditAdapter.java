package com.proyecto2027.soportebancario.infrastructure.audit;

import com.proyecto2027.soportebancario.application.AuditPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoggingAuditAdapter implements AuditPort {

    private static final Logger log = LoggerFactory.getLogger(LoggingAuditAdapter.class);

    @Override
    public void record(String action, UUID aggregateId, String detail) {
        log.info("audit action={} aggregateId={} detail={}", action, aggregateId, detail);
    }
}
