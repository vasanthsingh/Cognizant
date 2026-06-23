CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accid NUMBER,
    p_amount NUMBER
)
RETURN VARCHAR2
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accid;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;
END;
/