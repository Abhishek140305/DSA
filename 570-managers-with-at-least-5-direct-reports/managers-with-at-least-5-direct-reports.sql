SELECT e.name
FROM Employee AS e 
INNER JOIN Employee AS m ON e.id = m.managerId 
GROUP BY m.managerId 
HAVING COUNT(m.managerId) >= 5

/*
1. `e.name` is not included in `GROUP BY`,
violating SQL standards (e.g., in strict mode
like MySQL’s `ONLY_FULL_GROUP_BY`).
2. Even if `e.id = m.managerId` is unique,
this is technically invalid in strict
SQL dialects (e.g., PostgreSQL).
3. Low performance. Why? Read below.
*/