package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;
import it.unibo.oop.lab04.bank.SimpleBankAccount;

abstract class AbstractBankAccount implements BankAccount{
	
	public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private double balance;
    private int nTransactions;
    private final int usrID;

   
    
    public AbstractBankAccount(final int usrID, final double balance) {
        this.usrID = usrID;
        this.balance = balance;
        this.nTransactions = 0;
    }
    
    protected boolean checkUser(final int id) {
        return this.getID() == id;
    }
    
	public void computeManagementFees(int usrID) {
		double fees = computeFee();
		if (this.usrID == usrID) {
            this.balance -= fees;
        }
	}

    public void deposit(int usrID, double amount) {
    	if(this.usrID == usrID) {
    		this.balance += amount;
    		this.incTransactions();
    	}
    }

    public void depositFromATM(int usrID, double amount) {
    	 this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public double getBalance() {
    	return this.balance;
    }

    public int getNTransactions() {
    	return nTransactions;
    	
    }

    public void withdraw(int usrID, double amount) {
    	if(this.usrID == usrID) {
    		this.balance -= amount;
    		this.incTransactions();
    	}
    }

    public void withdrawFromATM(int usrID, double amount) {
    	this.withdraw(usrID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }
    
    public int getID() {
    	return this.usrID;
    }
    
    protected void incTransactions() {
        this.nTransactions++;
    }

    protected void resetTransactions() {
        this.nTransactions = 0;
    }

    protected void setBalance(final double amount) {
        this.balance = amount;
    }
     
    protected abstract boolean isWithdrawAllowed(double amount); 
    
    protected abstract double computeFee();
    
   
    
}
