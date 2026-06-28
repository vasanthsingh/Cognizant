DECLARE
    CURSOR c_acc IS
    SELECT AccountID FROM Accounts;

BEGIN
    FOR r IN c_acc LOOP
        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = r.AccountID;
    END LOOP;

    COMMIT;
END;
/