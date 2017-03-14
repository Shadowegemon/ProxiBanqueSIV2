package metier;

public class CardElectron extends BankCard{
	
	public CardElectron(long idClient) {
		super(idClient);
		super.type = BankCard.etype.ELECTRON;
	}
}
