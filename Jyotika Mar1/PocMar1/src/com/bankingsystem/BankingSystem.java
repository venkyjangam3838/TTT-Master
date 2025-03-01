package com.bankingsystem;

import java.util.Scanner;

//Abstract class representing a bank account
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

 // Getter methods
 public String getAccountNumber() {
     return accountNumber;
 }

 public String getAccountHolderName() {
     return accountHolderName;
 }

 public double getBalance() {
     return balance;
 }

 // Deposit method (common for all accounts)
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Abstract method for withdrawal (implemented in subclasses)
 public abstract void withdraw(double amount);
}

//Savings Account class
class SavingsAccount extends BankAccount {
 private static final double MIN_BALANCE = 500.0;

 public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Insufficient balance or minimum balance requirement not met.");
     }
 }
}

//Current Account class
class CurrentAccount extends BankAccount {
 public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
     super(accountNumber, accountHolderName, balance);
 }

 @Override
 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Insufficient balance.");
     }
 }
}

//Main class to interact with the user
public class BankingSystem {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // User inputs for account details
     System.out.print("Enter Account Number: ");
     String accountNumber = scanner.nextLine();

     System.out.print("Enter Account Holder Name: ");
     String accountHolderName = scanner.nextLine();

     System.out.print("Enter Initial Balance: ");
     double balance = scanner.nextDouble();

     System.out.print("Choose Account Type (1: Savings, 2: Current): ");
     int choice = scanner.nextInt();

     BankAccount account;
     if (choice == 1) {
         account = new SavingsAccount(accountNumber, accountHolderName, balance);
     } else {
         account = new CurrentAccount(accountNumber, accountHolderName, balance);
     }

     // Banking operations
     while (true) {
         System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
         System.out.print("Choose an option: ");
         int option = scanner.nextInt();

         if (option == 1) {
             System.out.print("Enter deposit amount: ");
             double amount = scanner.nextDouble();
             account.deposit(amount);
         } else if (option == 2) {
             System.out.print("Enter withdrawal amount: ");
             double amount = scanner.nextDouble();
             account.withdraw(amount);
         } else if (option == 3) {
             System.out.println("Current Balance: " + account.getBalance());
         } else if (option == 4) {
             System.out.println("Thank you for banking with us!");
             break;
         } else {
             System.out.println("Invalid choice, please try again.");
         }
     }
     scanner.close();
 }
}

