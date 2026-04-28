alter table outbox_events
    add column published_at timestamptz,
    add column last_error text;
