-- Exercise 1: Control Structures

-- Tables used:
-- Customers(CustomerID, Name, Age, Balance, IsVIP)
-- Loans(LoanID, CustomerID, InterestRate, DueDate)

-- Scenario 1: Give 1% interest rate discount to customers older than 60
BEGIN
    FOR rec IN (SELECT c.CustomerID, l.LoanID, l.InterestRate
                FROM Customers c
                JOIN Loans l ON c.CustomerID = l.CustomerID
                WHERE c.Age > 60)
    LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID ||
                             ', New Interest Rate: ' || (rec.InterestRate - 1) || '%');
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Mark customers as VIP if their balance is above 10000
BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers)
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('VIP status granted to: ' || rec.Name ||
                                 ' (Balance: ' || rec.Balance || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in the next 30 days
BEGIN
    FOR rec IN (SELECT l.LoanID, c.Name, l.DueDate
                FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name ||
                             ', your loan (ID: ' || rec.LoanID ||
                             ') is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/
