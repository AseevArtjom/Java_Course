CREATE TABLE IF NOT EXISTS public.Trucks
(
    Id           SERIAL PRIMARY KEY,
    Name         VARCHAR(60),
    IsCrashed    BOOLEAN,
    IsInTrip     BOOLEAN,
    RequestId    INT,
    MaxWeight INT
);

CREATE TABLE IF NOT EXISTS public.Drivers
(
    Id         SERIAL PRIMARY KEY,
    Name       VARCHAR(60),
    Cash       money,
    IsInTrip   BOOLEAN,
    Experience FLOAT
);

CREATE TABLE IF NOT EXISTS public.Destinations
(
    Id SERIAL PRIMARY KEY,
    Name VARCHAR,
    Distance FLOAT
);

CREATE TABLE IF NOT EXISTS public.ProductTypes
(
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS public.Requests
(
    Id SERIAL PRIMARY KEY,
    Weight DECIMAL,
    Required_Experience INT,
    Destination_Id INT,
    ProductType_Id INT,
    FOREIGN KEY (ProductType_Id) REFERENCES ProductTypes(Id) ON DELETE CASCADE ,
    FOREIGN KEY (Destination_Id) REFERENCES Destinations(Id) ON DELETE CASCADE
);
