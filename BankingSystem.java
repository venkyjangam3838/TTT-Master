package com28mins.com;

import java.util.Scanner;

//Abstract class BankAccount
abstract class BankAccount {
 private String accountNumber;
 private String accountHolderName;
 protected double balance;

 // Constructor
 public BankAccount(String accountNumber, String accountHolderName, double balance) {
     this.accountNumber = accountNumber;
     this.accountHolderName = accountHolderName;
     this.balance = balance;
 }

 // Getters
 public String getAccountNumber() {
     return accountNumber;
 }

 public String getAccountHolderName() {
     return accountHolderName;
 }

 public double getBalance() {
     return balance;
 }

 // Deposit method
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Abstract withdraw method
 public abstract void withdraw(double amount);

 // Display account details
 @Override
 public String toString() {
     return "Account Number: " + accountNumber +
             ", Account Holder: " + accountHolderName +
             ", Balance: " + balance;
 }
}

//SavingsAccount class
class SavingsAccount extends BankAccount {
 private static final double MINIMUM_BALANCE = 1000; // Minimum balance requirement

 // Constructor
 public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 // Override withdraw method
 @Override
 public void withdraw(double amount) {
     if (amount > 0 && (balance - amount) >= MINIMUM_BALANCE) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Withdrawal failed. Insufficient balance or minimum balance requirement not met.");
     }
 }
}

//CurrentAccount class
class CurrentAccount extends BankAccount {
 // Constructor
 public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 // Override withdraw method
 @Override
 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Withdrawal failed. Insufficient balance.");
     }
 }
}

//Banking System
public class BankingSystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Create accounts
     BankAccount savingsAccount = new SavingsAccount("SA001", "Alice", 5000);
     BankAccount currentAccount = new CurrentAccount("CA001", "Bob", 10000);

     while (true) {
         System.out.println("\nBanking System Menu");
         System.out.println("1. Deposit to Savings Account");
         System.out.println("2. Withdraw from Savings Account");
         System.out.println("3. Deposit to Current Account");
         System.out.println("4. Withdraw from Current Account");
         System.out.println("5. Check Savings Account Balance");
         System.out.println("6. Check Current Account Balance");
         System.out.println("7. Exit");
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter deposit amount for Savings Account: ");
                 double depositSavings = scanner.nextDouble();
                 savingsAccount.deposit(depositSavings);
                 break;
             case 2:
                 System.out.print("Enter withdrawal amount for Savings Account: ");
                 double withdrawSavings = scanner.nextDouble();
                 savingsAccount.withdraw(withdrawSavings);
                 break;
             case 3:
                 System.out.print("Enter deposit amount for Current Account: ");
                 double depositCurrent = scanner.nextDouble();
                 currentAccount.deposit(depositCurrent);
                 break;
             case 4:
                 System.out.print("Enter withdrawal amount for Current Account: ");
                 double withdrawCurrent = scanner.nextDouble();
                 currentAccount.withdraw(withdrawCurrent);
                 break;
             case 5:
                 System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
                 break;
             case 6:
                 System.out.println("Current Account Balance: " + currentAccount.getBalance());
                 break;
             case 7:
                 System.out.println("Exiting the system. Goodbye!");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }
 }
}
