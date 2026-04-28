create table customers (
    id uuid primary key,
    document_number varchar(80) not null unique,
    full_name varchar(200) not null,
    email varchar(200) not null,
    created_at timestamptz not null
);

create table support_tickets (
    id uuid primary key,
    customer_id uuid not null,
    subject varchar(200) not null,
    description text not null,
    priority varchar(20) not null,
    status varchar(30) not null,
    created_at timestamptz not null,
    constraint fk_support_tickets_customer
        foreign key (customer_id) references customers (id)
);

create index idx_support_tickets_customer_id
    on support_tickets (customer_id);

create index idx_support_tickets_status
    on support_tickets (status);
