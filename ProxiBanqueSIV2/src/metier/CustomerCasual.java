package metier;


public class CustomerCasual extends Client{
	


	public CustomerCasual(long id, String idAgence, String lastName, String firstName, String cellphone, String adress, String zipCode, String town, String email) {
		super(id, idAgence, lastName, firstName, cellphone,  adress,  zipCode,  town, email);
		super.type = Client.etype.CASUAL;
		super.overdraftRate = -1000.0;
		
	}
	public CustomerCasual(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", "", "", "", "", "");
	}
	


	
}
