CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    Age          NUMBER,
    Balance      NUMBER(10, 2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    InterestRate NUMBER(5, 2),
    DueDate      DATE
);

-- Sample data
INSERT INTO Customers VALUES (1, 'Ravi Kumar',   65, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Priya Sharma', 45,  8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'Arjun Das',    70, 12000, 'FALSE');
INSERT INTO Customers VALUES (4, 'Neha Verma',   30,  5000, 'FALSE');
INSERT INTO Customers VALUES (5, 'Suresh Nair',  62, 20000, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 8.5,  SYSDATE + 10);
INSERT INTO Loans VALUES (102, 2, 7.0,  SYSDATE + 45);
INSERT INTO Loans VALUES (103, 3, 9.0,  SYSDATE + 20);
INSERT INTO Loans VALUES (104, 4, 6.5,  SYSDATE + 5);
INSERT INTO Loans VALUES (105, 5, 8.0,  SYSDATE + 100);

COMMIT;
