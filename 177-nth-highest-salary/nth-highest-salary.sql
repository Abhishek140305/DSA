CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        SELECT 
            MAX(CASE WHEN T.rnk = @N THEN T.salary END) AS getNthHighestSalary
        FROM (
            SELECT 
                salary,
                DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
            FROM Employee
        ) T
    );
END