# Write your MySQL query statement below
# select Customers.name as Customers  from Customers where Customers.id not in(select Orders.CustomerId from Orders);
select name as Customers from Customers  Left join Orders on Customers.id=Orders.customerId where  Orders.customerId is null;