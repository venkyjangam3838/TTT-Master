package Bank;

abstract class BankAccount {
 private String accountNumber;
 private String accountHolderName;
 protected double balance;

 public BankAccount(String accountNumber, String accountHolderName, double balance) {
     this.accountNumber = accountNumber;
     this.accountHolderName = accountHolderName;
     this.balance = balance;
 }

 public String getAccountNumber() { return accountNumber; }
 public String getAccountHolderName() { return accountHolderName; }
 public double getBalance() { return balance; }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println(amount + " deposited. New Balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 public abstract boolean withdraw(double amount);
}

class SavingsAccount extends BankAccount {
 private static final double MIN_BALANCE = 500;

 public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 @Override
 public boolean withdraw(double amount) {
     if (balance - amount >= MIN_BALANCE) {
         balance -= amount;
         System.out.println(amount + " withdrawn. New Balance: " + balance);
         return true;
     } else {
         System.out.println("Insufficient balance. Maintain minimum balance of " + MIN_BALANCE);
         return false;
     }
 }
}

class CurrentAccount extends BankAccount {
 private static final double OVERDRAFT_LIMIT = 10000;

 public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 @Override
 public boolean withdraw(double amount) {
     if (balance - amount >= -OVERDRAFT_LIMIT) {
         balance -= amount;
         System.out.println(amount + " withdrawn. New Balance: " + balance);
         return true;
     } else {
         System.out.println("Overdraft limit exceeded! Maximum overdraft: " + OVERDRAFT_LIMIT);
         return false;
     }
 }
}

public class BankAccountSys {
 public static void main(String[] args) {
     SavingsAccount savings = new SavingsAccount("SA2002", "Pooja", 1000);
     CurrentAccount current = new CurrentAccount("CA2001", "Prathyusha", 5000);

     System.out.println("\nInitial Balances:");
     System.out.println("Savings: " + savings.getBalance());
     System.out.println("Current: " + current.getBalance());

     savings.deposit(1000);
     current.deposit(2000);

     System.out.println("\nAttempting Withdrawals:");
     savings.withdraw(1200); 
     savings.withdraw(800);  
     current.withdraw(7000); 
     current.withdraw(12000); 
 }
}
