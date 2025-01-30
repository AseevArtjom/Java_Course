CREATE TABLE IF NOT EXISTS public.Trucks
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(60),
    is_crashed BOOLEAN,
    is_in_trip BOOLEAN,
    bought     BOOLEAN,
    request_id INT,
    max_weight DECIMAL
);

CREATE TABLE IF NOT EXISTS public.Drivers
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(60),
    cash       DECIMAL,
    is_in_trip BOOLEAN,
    is_hired   BOOLEAN,
    experience FLOAT
);

CREATE TABLE IF NOT EXISTS public.Destinations
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR,
    distance FLOAT
);

CREATE TABLE IF NOT EXISTS public.Product_Types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS public.Requests
(
    id                  SERIAL PRIMARY KEY,
    weight              DECIMAL,
    required_experience INT,
    destination_id      INT,
    product_type_id     INT,
    progress            BOOLEAN,
    profit              DECIMAL,
    delivery_days       INT,
    remaining_days      INT,
    driver_id           INT,
    truck_id            INT,
    FOREIGN KEY (product_type_id) REFERENCES Product_Types (Id) ON DELETE CASCADE,
    FOREIGN KEY (destination_id) REFERENCES Destinations (Id) ON DELETE CASCADE
);
