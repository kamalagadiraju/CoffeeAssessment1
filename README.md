# Developer Assessment

##Description
The assessment comes with 3 JSON files. The files contain data for products, orders and payments.

Write a program that retrieves the following information given the provided files:
- Amount paid per user.
- Amount that each users still owes.

##Requirements
- The program should be written in Java.
- Write production-ready code.
- Document how to run the application.
- Publish the source code into GitHub (using your own personal account) and share it with us.

##How to run this application
- Right click on the Application.java and Run As Java application.
- The output will be displayed in the console

##Brief Description Of My Solution
I have iterated through the orders and grouped them by user.
 I have calculated the cost for each order by getting the cost of the drink from products.
 I have calculated the total cost of all orders for each user.
 I have compared the total amount with the amount already payed by user with the data from payments.
 I have calculated the difference between the total amount to be paid and amount already paid to get the amount owed by user.
 I found that many users in payments.json have already paid more amount than the total cost of their orders.
 That is why i am printing another column "Excess Amount Paid" as many users don't owe any money but have paid more.
 I am not sure if the data given is incorrect or if this is expected.