package com.bank;

 abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

   
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public abstract void withdraw(double amount);
}

 


 

  class SavingsAccount extends BankAccount {
	    private static final double MINIMUM_BALANCE = 500.0;

	    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount > 0 && (balance - amount) >= MINIMUM_BALANCE) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	           
	        } else {
	            System.out.println("Insufficient balance or minimum balance requirement not met.");
	        }
	    }
	}
  
  
   class CurrentAccount extends BankAccount {

	    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
	        super(accountNumber, accountHolderName, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    }
	}

   
   public class BankingSystem {
	    public static void main(String[] args) {
	    
	        BankAccount savingsAccount = new SavingsAccount("SBI001SA", "Monish", 1000.0);
	        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
	        savingsAccount.deposit(500.0);
	        savingsAccount.withdraw(200.0);
	        savingsAccount.withdraw(1500.0);
	        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());

	        System.out.println("-------------------------------------------------------------");
	       
	        BankAccount currentAccount = new CurrentAccount("SBI001CA", "Monish", 2000.0);
	        System.out.println("Current Account Balance: " + currentAccount.getBalance());
	        currentAccount.deposit(1000.0);
	        currentAccount.withdraw(1500.0);
	        currentAccount.withdraw(3000.0);
	        System.out.println("Current Account Balance: " + currentAccount.getBalance());
	    }
	}

