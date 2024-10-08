package task2;

import java.util.*;

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
            System.out.println("Deposit successful.n");
        } else {
            System.out.println("Invalid deposit amount.\n");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.\n");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. \n");
        } else {
            System.out.println("Insufficient balance for withdrawal.\n");
        }
    }
}

class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("================Welcome To TopperWorld ATM Menu==============\n");
        System.out.println("1. Check Balance\n");
        System.out.println("2. Deposit\n");
        System.out.println("3. Withdraw\n");
        System.out.println("4. Exit\n");
    }

    public void start() {
        Scanner vaibhao = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: \n");
            System.out.println("______________________________________________________");
            choice = vaibhao.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: \n");
                    double depositAmount = vaibhao.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: \n");
                    double withdrawalAmount = vaibhao.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("*********************************************");
                    System.out.println("Exiting TopperWorld ATM. Thank you Contact With Us!");
                    System.out.println("*********************************************");
                    break;
                default:
                    System.out.println("*********************************************");
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("*********************************************");
            }
        } while (choice != 4);

    }
}

public class ATM_Interface {

    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM object and connect it to the user's bank account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}