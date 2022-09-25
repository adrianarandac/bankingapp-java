import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    void deposit(int amount) {
        balance += amount;
        previousTransaction = amount;
        System.out.println("Deposited: " + amount + ". Current balance = " + balance);

    }

    void withdraw(int amount) {
        balance -= amount;
        previousTransaction = -amount;
        System.out.println("You've withdrawn: " + amount + ". Current balance = " + balance);

    }

    void getPreviousTransaction() {
        if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + previousTransaction);
        } else if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else {
            System.out.println("No operations performed");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0185;
        double result = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + result);
    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A' -> {
                    System.out.println("====================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("====================================");
                    System.out.println();
                }
                //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                case 'B' -> {
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                }
                //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                case 'C' -> {
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                }
                //Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
                case 'D' -> {
                    System.out.println("====================================");
                    getPreviousTransaction();
                    System.out.println("====================================");
                    System.out.println();
                }
                //Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                case 'E' -> {
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                }
                //The default case lets the user know that they entered an invalid character and how to enter a valid one
                default ->
                        System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");

            }
            System.out.println();
            System.out.println("A. Check your balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdrawal");
            System.out.println("D. View previous transaction");
            System.out.println("E. Calculate interest");
            System.out.println("F. Exit");
        }
        while (option != 'F');
        System.out.println("====================================");
        System.out.println("Thank you for trusting us!");


    }
}