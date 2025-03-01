package bankingSystem;


   public class BankingSystem {
 
    public static void main(String[] args) {
		     // Creating SavingsAccount object
    	 BankAccount savingsAccount = new SavingsAccount("SA12345", "Prabhas", 1000);
	     savingsAccount.deposit(500);  // Deposit in Savings Account
	     savingsAccount.withdraw(300); // Withdrawal from Savings Account
	     savingsAccount.withdraw(1200); // Attempt to withdraw more than allowed balance in Savings Account

	     System.out.println("------------------------------------------------------------------------------");
		     // Creating CurrentAccount object
	     BankAccount currentAccount = new CurrentAccount("CA12345", "NTR", 2000);
	     currentAccount.deposit(1000); // Deposit in Current Account
	     currentAccount.withdraw(1500); // Withdrawal from Current Account
	     currentAccount.withdraw(3500); // Attempt to withdraw more than available balance in Current Account
		 }

}

//Abstract Class BankAccount
abstract class BankAccount {
private String accountNumber;
private String accountHolderName;
private double balance;

// Constructor
public BankAccount(String accountNumber, String accountHolderName, double balance) {
   this.accountNumber = accountNumber;
   this.accountHolderName = accountHolderName;
   this.balance = balance;
}

// Getters and Setters (Encapsulation)
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

public void setBalance(double balance) {
   this.balance = balance;
}

// Deposit method (common to both account types)
public void deposit(double amount) {
   if (amount > 0) {
       balance += amount;
       System.out.println("Deposited " + amount + ". New balance: " + balance);
   } else {
       System.out.println("Deposit amount must be positive.");
   }
}

// Abstract method to be implemented by subclasses for withdrawal behavior
public abstract void withdraw(double amount);

}


//SavingsAccount Class
class SavingsAccount extends BankAccount {
private static final double MIN_BALANCE = 500; // Minimum balance for savings account

public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
   super(accountNumber, accountHolderName, balance);
}

@Override
public void withdraw(double amount) {
   if (getBalance() - amount >= MIN_BALANCE) {
       setBalance(getBalance() - amount);
       System.out.println("Withdrawal successful! New balance: " + getBalance());
   } else {
       System.out.println("Insufficient balance or below minimum balance for withdrawal.");
   }
}
}


//CurrentAccount Class
class CurrentAccount extends BankAccount {
public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
   super(accountNumber, accountHolderName, balance);
}

@Override
public void withdraw(double amount) {
   if (amount <= getBalance()) {  
       setBalance(getBalance() - amount);
       System.out.println("Withdrawal successful! New balance: " + getBalance());
   } else {
       System.out.println("Insufficient balance for withdrawal.");
   }
}
}

    
