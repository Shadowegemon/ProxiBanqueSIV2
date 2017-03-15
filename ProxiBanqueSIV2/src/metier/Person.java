package metier;



public class Person {
	private long id;
	private String idAgence;
	private String lastName;
	private String firstName;
	private String cellphone;
	private String email;

	public Person(long id, String adAgence, String lastName, String firstName, String cellphone, String email) {
		this.id = id;
		this.idAgence = adAgence;
		this.lastName = lastName;
		this.firstName = firstName;
		this.cellphone = cellphone;
		this.email = email;
	}

	
	public Person(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", "", "");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
