# DiscountApplication
DiscountApplication is a Java project in which the users are allowed to get discounts on their bill amounts based on the  user types: Employee, Affiliate, LongTermUser (more than or equal to 2 years) and RecentUser (less than 2 years)
Instruction to run the DiscountApplication
------------------------------------------

Both the source code (src) and compile binary code (bin) are available in the project folder.

If required, the src code contents can be compiled to bin files can be generated.

The DiscountApplication requires the following 3 files:

Bill.java describes the bills and the discounts based on user types
UserType.java describes the user types
User.java describes the users and update all the users in a userList.

The test cases are written as JUnit test methods in TestJunit.java
All the JUnit test methods are called from TestDiscountApp.java and final result is reported
as true if all the test cases pass.

The package is ind.vsanandan.app
Enter into the DiscountApplication folder using the command:

        cd DiscountApplication

From the command line the app can be run using the command if all the imported files are in the path:

        java ind.vsanandan.app.TestDiscountApp

Otherwise, the whole project can be imported into Eclipse IDE and allowed to run the TestDiscountApp file.

Using JUnit app, even the TestJunit.java can be run and result of each of the 16 test cases can be seen true.
