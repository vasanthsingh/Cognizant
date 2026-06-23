BEGIN
    FOR r IN (
        SELECT c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan of ' || r.Name ||
            ' is due on ' || r.EndDate
        );
    END LOOP;
END;
/