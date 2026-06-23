CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_acc NUMBER,
        p_cust NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_acc NUMBER
    );

    FUNCTION TotalBalance(
        p_cust NUMBER
    ) RETURN NUMBER;

END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_acc NUMBER,
        p_cust NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts
        VALUES(
            p_acc,p_cust,p_type,
            p_balance,SYSDATE
        );
    END;

    PROCEDURE CloseAccount(
        p_acc NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_acc;
    END;

    FUNCTION TotalBalance(
        p_cust NUMBER
    ) RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_cust;

        RETURN v_total;
    END;

END;
/