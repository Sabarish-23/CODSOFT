/*
TASK 3
ATM INTERFACE
 1. Create a class to represent the ATM machine.
 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
 checking the balance.
 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
 checkBalance().
 4. Create a class to represent the user's bank account, which stores the account balance.
 5. Connect the ATM class with the user's bank account class to access and modify the account
 balance.
 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
 7. Display appropriate messages to the user based on their chosen options and the success or failure
 of their transactions.
  */

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000); // Initial balance

        boolean exit = false;

        System.out.println("Welcome to the ATM Machine!");

        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

/*
SAMPLE INPUT/OUTPUT:
Welcome to the ATM Machine!

Please choose an option:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Your choice: 1
Enter amount to withdraw: 8000
Insufficient balance.

Please choose an option:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Your choice: 2
Enter amount to deposit: 500000
Successfully deposited: 500000.0

Please choose an option:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Your choice: 1
Enter amount to withdraw: 50000
Successfully withdrew: 50000.0

Please choose an option:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Your choice: 3
Your current balance is: 455000.0

Please choose an option:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Your choice: 4
Thank you for using the ATM. Goodbye!
*/
