CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan NUMBER,
    p_rate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_months NUMBER;
BEGIN
    v_months := p_years * 12;

    RETURN (p_loan + (p_loan*p_rate/100*p_years))
           / v_months;
END;
/