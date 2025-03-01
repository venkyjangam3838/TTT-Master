package com.learn.poc;

public abstract class BankAccount {

	 protected String accountNumber;
	    protected String accountHolderName;
	    protected double balance;

	    public BankAccount(String accountNumber, String accountHolderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = balance;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited " + amount + ". New balance: " + balance);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    public abstract void withdraw(double amount);

	    public void checkBalance() {
	        System.out.println("Account Holder: " + accountHolderName + ", Balance: " + balance);
	    }
	}

	class SavingsAccount extends BankAccount {
	    private static final double MIN_BALANCE = 500;

	    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (balance - amount >= MIN_BALANCE) {
	            balance -= amount;
	            System.out.println("Withdrawn " + amount + ". New balance: " + balance);
	        } else {
	            System.out.println("Insufficient balance. Minimum balance of " + MIN_BALANCE + " must be maintained.");
	        }
	    }
	}

	class CurrentAccount extends BankAccount {
	    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn " + amount + ". New balance: " + balance);
	        } else {
	            System.out.println("Insufficient funds.");
	        }
	    }
	}

	

