package com.poc;

abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    protected double balance; // Protected to allow access in subclasses

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit method 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract method for withdrawal 
    public abstract void withdraw(double amount);

    // Getters for encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}

// Savings Account with a minimum balance requirement
class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or minimum balance requirement not met.");
        }
    }
}

// Current Account without a minimum balance restriction
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

// Testing function
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA12345", "Anu", 1000);
        CurrentAccount current = new CurrentAccount("CA67890", "Bunny", 2000);

       
        savings.deposit(500);
        current.deposit(1000);

        
        savings.withdraw(800); // Should fail due to min balance constraint
        savings.withdraw(400); // Should succeed

        current.withdraw(2500); // Should fail due to insufficient balance
        current.withdraw(1000); // Should succeed
    }
}

