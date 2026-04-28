create table outbox_events (
    id uuid primary key,
    aggregate_id uuid not null,
    event_type varchar(120) not null,
    payload text not null,
    status varchar(30) not null,
    occurred_at timestamptz not null,
    created_at timestamptz not null
);

create index idx_outbox_events_status_created_at
    on outbox_events (status, created_at);

create index idx_outbox_events_aggregate_id
    on outbox_events (aggregate_id);
