package com.ttt;

public class SavingsAccount extends BankAccount {
	private static final double MINIMUM_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MINIMUM_BALANCE) {
            super.deposit(-amount); 
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance. Minimum balance required: " + MINIMUM_BALANCE);
        }
    }

}
