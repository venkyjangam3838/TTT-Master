package com.ttt;

public class CurrentAccount extends BankAccount {
	
	public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            super.deposit(-amount); 
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }


}
