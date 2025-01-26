CREATE TYPE status AS ENUM('FREE', 'SOLD');

CREATE TABLE IF NOT EXISTS public.Places
(
    Id      SERIAL PRIMARY KEY,
    Address VARCHAR,
    Name    VARCHAR
);

CREATE TABLE IF NOT EXISTS public.Events
(
    Id         SERIAL PRIMARY KEY,
    Event_Date DATE,
    Name       VARCHAR,
    PlaceId    INT,
    FOREIGN KEY (PlaceId) REFERENCES Places (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.Customers
(
    Id    SERIAL PRIMARY KEY,
    Name  VARCHAR,
    Email VARCHAR,
    Phone VARCHAR
);

CREATE TABLE IF NOT EXISTS public.Tickets
(
    Id         SERIAL PRIMARY KEY,
    Cost       money,
    Number     INT,
    Status     status,
    CustomerId INT,
    EventId    INT,
    FOREIGN KEY (CustomerId) REFERENCES Customers (Id) ON DELETE CASCADE,
    FOREIGN KEY (EventId) REFERENCES Events (Id) ON DELETE CASCADE
);

