
package metier;

public class BankAccount {

	// attributs
	private long idClient;
	private long numAccount;
	private double sold;
	private String openDate;

	public enum etype {
		CURRENT_ACCOUNT, SAVING_ACCOUNT
	};

	protected etype type;

	// constructeur

	public etype getType() {
		return type;
	}

	public BankAccount(long idClient, double sold, String openDate, etype type) {
		super();
		this.idClient = idClient;
		this.type = type;
		this.sold = sold;
		this.openDate = openDate;
	}

	// Getters setters
	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold += sold;
	}

	public long getIdClient() {
		return idClient;
	}

	public long getNumAccount() {
		return numAccount;
	}

	public String getOpenDate() {
		return openDate;
	}

}
