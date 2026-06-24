CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    AccountType  VARCHAR2(20),
    Balance      NUMBER(10, 2)
);

CREATE TABLE Employees (
    EmployeeID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    Department   VARCHAR2(50),
    Salary       NUMBER(10, 2)
);

-- Sample accounts (mix of savings and current)
INSERT INTO Accounts VALUES (1, 1, 'SAVINGS', 5000);
INSERT INTO Accounts VALUES (2, 2, 'CURRENT', 8000);
INSERT INTO Accounts VALUES (3, 3, 'SAVINGS', 12000);
INSERT INTO Accounts VALUES (4, 4, 'SAVINGS', 3000);
INSERT INTO Accounts VALUES (5, 5, 'CURRENT', 15000);

-- Sample employees
INSERT INTO Employees VALUES (1, 'Ravi Kumar',   'IT',      50000);
INSERT INTO Employees VALUES (2, 'Priya Sharma', 'IT',      55000);
INSERT INTO Employees VALUES (3, 'Arjun Das',    'HR',      45000);
INSERT INTO Employees VALUES (4, 'Neha Verma',   'HR',      48000);
INSERT INTO Employees VALUES (5, 'Suresh Nair',  'Finance', 60000);

COMMIT;
