package com.ttt;

import java.util.Scanner;

public class BankingSystem {

	private BankAccount account;
	private Scanner scanner;

	public BankingSystem(BankAccount account) {
		this.account = account;
		this.scanner = new Scanner(System.in);
	}

	public void run() {
		while (true) {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = Double.parseDouble(scanner.nextLine());
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdrawalAmount = Double.parseDouble(scanner.nextLine());
				account.withdraw(withdrawalAmount);
				break;
			case 3:
				System.out.println("Current balance: " + account.getBalance());
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
	public static void main(String[] args) {
		BankAccount savingsAccount = new SavingsAccount("SAV001", "John Doe", 1000.0);
		BankingSystem bankingSystem = new BankingSystem(savingsAccount);
		bankingSystem.run();
	}



}
