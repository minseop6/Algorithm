SELECT MAX(Salary) as SecondHighestSalary FROM Employee
WHERE Salary NOT IN (SELECT MAX(Salary) from Employee)