package it.unibo.oop.lab04.bank2;


public class ClassicBankAccount extends AbstractBankAccount{
	
	
    public static final double MANAGEMENT_FEE = 5;

    public ClassicBankAccount(final int usrID, final double balance) {
       super(usrID,balance);
    }

	protected boolean isWithdrawAllowed(double amount) {
		return this.getBalance() > amount;
	}

	protected double computeFee() {
		return MANAGEMENT_FEE;
	}
	
}
