CREATE TABLE IF NOT EXISTS public.Clients
(
    Id       SERIAL PRIMARY KEY,
    FirstName      VARCHAR(40),
    LastName      VARCHAR(40),
    Birth    DATE,
    Phone    VARCHAR(16),
    Mail     VARCHAR(30),
    DISCOUNT INT
);

CREATE TABLE IF NOT EXISTS public.Positions
(
    Id   SERIAL PRIMARY KEY,
    Name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS public.Staff
(
    Id         SERIAL PRIMARY KEY,
    FirstName      VARCHAR(40),
    LastName      VARCHAR(40),
    Phone      VARCHAR(16),
    Mail       VARCHAR(30),
    PositionId INT,
    FOREIGN KEY (PositionId) REFERENCES Positions (Id)
);

CREATE TABLE IF NOT EXISTS public.MenuItemsType
(
    Id   SERIAL PRIMARY KEY,
    Name VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS public.MenuItems
(
    Id       SERIAL PRIMARY KEY,
    Name_ENG VARCHAR(80),
    Name_RU  VARCHAR(80),
    TypeId   INT,
    Cost     money,
    FOREIGN KEY (TypeId) REFERENCES MenuItemsType (Id)
);

CREATE TABLE IF NOT EXISTS public.History
(
    Id   SERIAL PRIMARY KEY,
    Cost money,
    TotalOrderCost money,
    Created DATE,
    Client_FirstName VARCHAR(40),
    Client_LastName VARCHAR(40),
    Staff_FirstName VARCHAR(40),
    Staff_LastName VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS public.Orders
(
    Id        SERIAL PRIMARY KEY,
    ClientId  INT,
    StaffId   INT,
    TotalCost money,
    Created   DATE,
    FOREIGN KEY (ClientId) REFERENCES Clients (Id),
    FOREIGN KEY (StaffId) REFERENCES Staff (Id)
);