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
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close(); // Close the scanner to prevent resource leaks
    }

    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount(1000); // You can set initial balance here

        // Create an ATM instance and connect it to the account
        ATM atm = new ATM(myAccount);

        // Run the ATM system
        atm.run();
    }
}