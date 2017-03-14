package metier;


public class CustomerEnterprise extends Client{
	

	public CustomerEnterprise(long id, String idAgence, String lastName, String firstName, String cellphone, String adress, String zipCode, String town) {
		super(id, idAgence, lastName, firstName, cellphone,  adress,  zipCode,  town);
		super.type = Client.etype.ENTERPRISE;
		super.overdraftRate = -1000.0;
		
	}
	public CustomerEnterprise(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", "", "", "", "");
	}

}
