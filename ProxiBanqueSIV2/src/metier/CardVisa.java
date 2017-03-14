package metier;

public class CardVisa extends BankCard{

	public CardVisa(long idClient) {
		super(idClient);
		super.type = BankCard.etype.VISA;
	}

}
