package metier;

public class AccountSaving extends BankAccount{

//	qttribut
	private double rateAccount;
	
	
//	Constructeur
	public AccountSaving(long numAccount, long idClient, double sold, String openDate) {
		super(numAccount,idClient, sold, openDate, etype.SAVING_ACCOUNT);
		this.rateAccount = 3.0/100.0;
		super.type = BankAccount.etype.SAVING_ACCOUNT;
	}

//	Getter setter
	public double getRateAccount() {
		return rateAccount;
	}


	public void setRateAccount(double rateAccount) {
		this.rateAccount = rateAccount;
	}
	

	
	

}
