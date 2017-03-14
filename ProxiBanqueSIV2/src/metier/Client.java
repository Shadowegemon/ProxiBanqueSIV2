package metier;

import java.util.ArrayList;
import java.util.List;

import service.ServiceActor;


public class Client extends Person {

	private Adviser aviserCurrent;
	private String address;
	private String zipCode;
	private String town;

	private List<BankAccount> listOfAccount = new ArrayList<>();
	private boolean clientIsRich;
	private BankCard currentCard;

	protected double overdraftRate;
	
	
	public enum etype{
		CASUAL,ENTERPRISE;
	}
	protected etype type;

	public Client(long id, String idAgence, String lastName, String firstName, long cellphone, String adress,
			String zipCode, String town) {
		super(id, idAgence, lastName, firstName, cellphone);
		this.address = adress;
		this.zipCode = zipCode;
		this.town = town;
		ServiceActor.addNewClient(this);
	}

	public Client(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", 0, "", "", ""); // 
	}

	public Adviser getIdAviser() {
		return aviserCurrent;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getTown() {
		return town;
	}

	public List<BankAccount> getListOfAccount() {
		return listOfAccount;
	}

	public void addBankAccount(BankAccount ba) {
		this.listOfAccount.add(ba);
	}

	public void AddBankCard(BankCard bc) {
		this.currentCard = bc;
	}

	public void removeBankAccount(BankAccount ba) {
		this.listOfAccount.remove(ba);
	}

	public boolean isClientIsRich() {
		return clientIsRich;
	}

	public BankCard getCurrentCard() {
		return currentCard;
	}

	public void setIdAviser(Adviser current) {
		this.aviserCurrent = current;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public etype getType() {
		return type;
	}

	public void setType(etype type) {
		this.type = type;
	}

	public void setClientIsRich(boolean clientIsRich) {
		this.clientIsRich = clientIsRich;
	}

	public double getOverdraftRate() {
		return overdraftRate;
	}

	public void setOverdraftRate(double overdraftRate) {
		this.overdraftRate = overdraftRate;
	}

	public BankAccount getAccount(BankAccount.etype type) {

		if (this.listOfAccount.size() > 0) {

			for (BankAccount bankAccount : this.listOfAccount) {
				if (bankAccount.getType().equals(type)) {
					//System.out.println("Client getAccount by type : "+type+" = "+bankAccount);
					return  bankAccount;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Client [idAviser=" + aviserCurrent + ", address=" + address + ", zipCode=" + zipCode + ", town=" + town
				+ ", listOfAccount=" + listOfAccount + ", clientIsRich=" + clientIsRich + ", currentCard=" + currentCard
				+ ", overdraftRate=" + overdraftRate + "]";
	}

}
