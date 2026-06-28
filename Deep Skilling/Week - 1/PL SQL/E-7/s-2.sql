CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_pos VARCHAR2,
        p_sal NUMBER,
        p_dept VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_sal NUMBER
    );

    FUNCTION AnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;
END;
/