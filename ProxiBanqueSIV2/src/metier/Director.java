package metier;


public class Director extends Person {

	public Director(String idAgence, String lastName, String firstName, long cellphone) {
		super(0, idAgence, lastName, firstName, cellphone);
	}
	
	public Director(String idAgence, String lastName) {
		this(idAgence, lastName, "", 0);
	}
	
	

}
