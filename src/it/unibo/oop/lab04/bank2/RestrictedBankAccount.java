package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {
	
	
    
    private static final double TRANSACTION_FEE = 0.1;
    
	
	public RestrictedBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	protected boolean isWithdrawAllowed(double amount) {
		return this.getBalance() >= amount;
	}
	
	public void withdraw(int usrID, double amount) {
		var balance = this.getBalance();
		if(this.getID() == usrID && this.isWithdrawAllowed(amount)) {
    		balance -= amount;
    		this.incTransactions();
    	}
	}
	
	protected double computeFee() {
		return MANAGEMENT_FEE + (TRANSACTION_FEE * this.getNTransactions());
	}

	
	 
	
}
