import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;


class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + " | User: " + username + " | Balance: " + balance;
    }
}

public class Main {

    static LinkedList<BankAccount> accounts = new LinkedList<>();

    static Stack<String> history = new Stack<>();

    static Queue<String> billQueue = new LinkedList<>();

    static Queue<BankAccount> accountRequests = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runTask6_PhysicalStructure();

        accounts.add(new BankAccount("1", "Ali", 150000));
        accounts.add(new BankAccount("2", "Sara", 220000));
        System.out.println("\n[System] Initial accounts added successfully.");

        runMainMenu();
    }


    public static void runTask6_PhysicalStructure() {
        System.out.println("=== Task 6: Physical Data Structure (Array) ===");

        BankAccount[] physicalArray = new BankAccount[3];
        physicalArray[0] = new BankAccount("A1", "John", 1000);
        physicalArray[1] = new BankAccount("A2", "Mike", 2000);
        physicalArray[2] = new BankAccount("A3", "Anna", 3000);



        for (BankAccount acc : physicalArray) {
            System.out.println(acc);
        }
        System.out.println("===============================================\n");
    }


    public static void runMainMenu() {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Enter Bank");
            System.out.println("2. Enter ATM");
            System.out.println("3. Admin Area");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": bankMenu(); break;
                case "2": atmMenu(); break;
                case "3": adminMenu(); break;
                case "4":
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default: System.out.println("Invalid input!");
            }
        }
    }

    // --- BANK MENU ---
    public static void bankMenu() {
        System.out.println("\n--- BANK MENU ---");
        System.out.println("1. Submit account opening request"); //
        System.out.println("2. Deposit money"); // [cite: 105]
        System.out.println("3. Withdraw money"); // [cite: 106]
        System.out.println("4. Transaction History (Undo/Peek)"); // Task 3
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter new account number: ");
                String accNum = scanner.nextLine();
                System.out.print("Enter username: ");
                String name = scanner.nextLine();
                System.out.print("Enter initial balance: ");
                double balance = Double.parseDouble(scanner.nextLine());
                // Task 5: Add account request to queue [cite: 84]
                accountRequests.add(new BankAccount(accNum, name, balance));
                System.out.println("Request submitted. Waiting for admin approval.");
                break;
            case "2":
                performTransaction(true); // Task 2 Deposit
                break;
            case "3":
                performTransaction(false); // Task 2 Withdraw
                break;
            case "4":
                handleHistory(); // Task 3 Stack operations
                break;
            case "5": return;
            default: System.out.println("Invalid input!");
        }
    }

    // --- ATM MENU ---
    public static void atmMenu() {
        System.out.println("\n--- ATM MENU ---");
        System.out.println("1. Balance enquiry"); //
        System.out.println("2. Withdraw money"); //
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter username: ");
                String name = scanner.nextLine();
                BankAccount acc = findAccount(name); // Task 1 Search
                if (acc != null) {
                    System.out.println("Balance for " + name + ": " + acc.balance);
                } else {
                    System.out.println("Account not found.");
                }
                break;
            case "2":
                performTransaction(false); // Task 2 Withdraw
                break;
            case "3": return;
            default: System.out.println("Invalid input!");
        }
    }

    // --- ADMIN MENU ---
    public static void adminMenu() {
        System.out.println("\n--- ADMIN MENU ---");
        System.out.println("1. View and process account queue");
        System.out.println("2. View and process bill payment queue");
        System.out.println("3. Add bill to queue (Simulation)");
        System.out.println("4. Display all active accounts");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // Task 5: Process request
                System.out.println("Pending account requests: " + accountRequests.size());
                if (!accountRequests.isEmpty()) {
                    BankAccount newAcc = accountRequests.poll();
                    accounts.add(newAcc);
                    System.out.println("Processed and approved: " + newAcc.username);
                } else {
                    System.out.println("No pending requests.");
                }
                break;
            case "2":
                // Task 4: Process next bill payment [cite: 72]
                System.out.println("Bills in queue: " + billQueue); //
                if (!billQueue.isEmpty()) {
                    String bill = billQueue.poll();
                    System.out.println("Processing: " + bill); //
                    history.push("Bill paid: " + bill); // Task 3
                } else {
                    System.out.println("No bills to process.");
                }
                break;
            case "3":
                System.out.print("Enter bill name (e.g., Electricity Bill): ");
                String billName = scanner.nextLine();
                billQueue.add(billName);
                System.out.println("Added: " + billName);
                break;
            case "4":
                System.out.println("Accounts List:");
                for (BankAccount a : accounts) {
                    System.out.println(a.username + " - Balance: " + a.balance);
                }
                break;
            case "5": return;
            default: System.out.println("Invalid input!");
        }
    }

    // --- UTILITY METHODS ---


    public static BankAccount findAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }


    public static void performTransaction(boolean isDeposit) {
        System.out.print("Enter username: "); // [cite: 47]
        String name = scanner.nextLine();
        BankAccount acc = findAccount(name);

        if (acc != null) {
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (isDeposit) {
                acc.balance += amount; // [cite: 45]
                System.out.println("Deposit: " + amount); // [cite: 48]
                history.push("Deposit " + amount + " to " + name); //
            } else {
                if (acc.balance >= amount) {
                    acc.balance -= amount; // [cite: 45]
                    System.out.println("Withdraw: " + amount);
                    history.push("Withdraw " + amount + " from " + name); //
                } else {
                    System.out.println("Insufficient funds!");
                    return;
                }
            }
            System.out.println("New balance: " + acc.balance); //
        } else {
            System.out.println("Account not found!");
        }
    }


    public static void handleHistory() {
        System.out.println("1. Display last transaction (peek)");
        System.out.println("2. Undo last transaction (pop)");
        System.out.print("Choose: ");
        String opt = scanner.nextLine();

        if (opt.equals("1")) {
            if (!history.isEmpty()) {
                System.out.println("Last transaction: " + history.peek());
            } else {
                System.out.println("No transactions yet.");
            }
        } else if (opt.equals("2")) {
            if (!history.isEmpty()) {
                String removed = history.pop();
                System.out.println("Undo: " + removed + " removed from history.");

            } else {
                System.out.println("No transactions to undo.");
            }
        }
    }
}
