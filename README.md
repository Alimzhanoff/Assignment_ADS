Assignment 2 - Physical & Logical Data Structures
**Student:** Alimzhan Adilzhan
**Group:** IT-2504


All my codes was wrote in Main.java used principles of OOP. 

To complete Task 1
Description: I created a BankAccount class with fields for account number, username, and balance. I used a LinkedList to store these accounts because it allows for dynamic data management without a fixed size. I added functionality to create new accounts, display the full list, and search for specific users by their name.

Task 2
Description:I expanded the code to handle money operations. I wrote logic that finds a user in the LinkedList and updates their balance when they make a deposit or a withdrawal.

Task 3
Description:I implemented a Stack of strings called transactionHistory. Every time a user completes a transaction, the program pushes a description of that action onto the stack. I also added a pop function to undo the last transaction and a peek function to show the most recent action.

Task 4 and 5, Description: I used the Queue structure. I created one queue for bill payments where requests are processed in a first-in, first-out order. I also made an accountRequests queue for the admin simulation. When a user asks to open a account, it stays in the queue until the admin processes it and moves it to the main LinkedList.

Task 6 
Description:I created a basic physical array of BankAccount objects with a size of 3. I filled it with predefined data and printed it to show how a fixed-size physical structure works compared to a logical one.Finally, I built a main menu that connects all these parts. It has three sections: a Bank Menu for user requests, an ATM Menu for balance checks and withdrawals, and an Admin Area to process the bill and account queues.













