package Banking;

import java.util.*;

public abstract class BankAccount {
	
	 protected String accountNumber;
	    protected String accountHolderName;
	    protected double balance;

	    // Constructor
	    public BankAccount(String accountNumber, String accountHolderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = balance;
	    }

	    // Deposit method (common to all accounts)
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Abstract withdraw method (to be implemented by subclasses)
	    public abstract void withdraw(double amount);

	    // Balance check method
	    public void checkBalance() {
	        System.out.println("Account Holder: " + accountHolderName + " | Balance: $" + balance);
	    }
	}

	// Savings Account (Minimum balance required)
	class SavingsAccount extends BankAccount {
	    private static final double MIN_BALANCE = 500;

	    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    // Withdraw method (Overridden)
	    @Override
	    public void withdraw(double amount) {
	        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
	            balance -= amount;
	            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
	        } else {
	            System.out.println("Insufficient balance! Minimum balance required: $" + MIN_BALANCE);
	        }
	    }
	}

	// Current Account (No minimum balance restriction)
	class CurrentAccount extends BankAccount {
	    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    // Withdraw method (Overridden)
	    @Override
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
	        } else {
	            System.out.println("Insufficient balance!");
	        }
	    }
	    public class BankingSystemApp {
	        public static void main(String[] args) {
	            Scanner scanner = new Scanner(System.in);

	            BankAccount savings = new SavingsAccount("SA123", "Alice", 1000);
	            BankAccount current = new CurrentAccount("CA456", "Bob", 2000);

	            System.out.println("Welcome to the Banking System!");

	            while (true) {
	                System.out.println("\n1. Deposit");
	                System.out.println("2. Withdraw");
	                System.out.println("3. Check Balance");
	                System.out.println("4. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();

	                System.out.print("Choose account (1: Savings, 2: Current): ");
	                int accountChoice = scanner.nextInt();
	                BankAccount account = (accountChoice == 1) ? savings : current;

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter deposit amount: ");
	                        double depositAmount = scanner.nextDouble();
	                        account.deposit(depositAmount);
	                        break;
	                    case 2:
	                        System.out.print("Enter withdrawal amount: ");
	                        double withdrawAmount = scanner.nextDouble();
	                        account.withdraw(withdrawAmount);
	                        break;
	                    case 3:
	                        account.checkBalance();
	                        break;
	                    case 4:
	                        System.out.println("Exiting system...");
	                        scanner.close();
	                        return;
	                    default:
	                        System.out.println("Invalid choice!");
	                }
	            }
	        }
	    }

}
