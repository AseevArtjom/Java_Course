CREATE TABLE IF NOT EXISTS public.Notice
(
    Id        SERIAL PRIMARY KEY,
    Message   VARCHAR,
    Type      VARCHAR,
    Processed BOOLEAN
);
