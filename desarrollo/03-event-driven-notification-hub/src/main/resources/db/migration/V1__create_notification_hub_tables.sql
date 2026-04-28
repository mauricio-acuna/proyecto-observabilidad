create table processed_events (
    event_id uuid primary key,
    processed_at timestamptz not null
);

create table notification_attempts (
    id uuid primary key,
    event_id uuid not null,
    event_type varchar(120) not null,
    recipient varchar(200) not null,
    status varchar(30) not null,
    detail text,
    attempted_at timestamptz not null
);

create index idx_notification_attempts_event_id
    on notification_attempts (event_id);

create index idx_notification_attempts_status_attempted_at
    on notification_attempts (status, attempted_at);

create table dead_letter_events (
    id uuid primary key,
    queue_name varchar(200) not null,
    payload text not null,
    failure_reason text,
    received_at timestamptz not null
);

create index idx_dead_letter_events_received_at
    on dead_letter_events (received_at);
