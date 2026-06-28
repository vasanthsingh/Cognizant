DECLARE
    CURSOR c_trans IS
    SELECT *
    FROM Transactions
    WHERE TRUNC(TransactionDate,'MM') =
          TRUNC(SYSDATE,'MM');

    r_trans Transactions%ROWTYPE;
BEGIN
    OPEN c_trans;

    LOOP
        FETCH c_trans INTO r_trans;
        EXIT WHEN c_trans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Account: '||r_trans.AccountID||
            ' Amount: '||r_trans.Amount
        );
    END LOOP;

    CLOSE c_trans;
END;
/