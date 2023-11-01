# Write your MySQL query statement below
select a.name as name ,b.bonus as bonus from Employee a left join  bonus as b on a.empId=b.empId where b.bonus is null or b.bonus<1000 ;