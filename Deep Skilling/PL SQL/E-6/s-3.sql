DECLARE
    CURSOR c_loan IS
    SELECT LoanID FROM Loans;

BEGIN
    FOR r IN c_loan LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = r.LoanID;
    END LOOP;

    COMMIT;
END;
/