package com.learn.poc;

public class BankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BankAccount savings = new SavingsAccount("S12345", "Alice", 1000);
	        BankAccount current = new CurrentAccount("C67890", "Bob", 5000);
	        
	        savings.deposit(500);
	        savings.withdraw(800);
	        savings.checkBalance();
	        
	        current.deposit(1000);
	        current.withdraw(7000);
	        current.checkBalance();
	    }

	}


