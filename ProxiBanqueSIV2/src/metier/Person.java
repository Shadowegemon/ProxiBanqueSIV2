package metier;



public class Person {
	private long id;
	private String idAgence;
	private String lastName;
	private String firstName;
	private long cellphone;

	public Person(long id, String adAgence, String lastName, String firstName, long cellphone) {
		this.id = id;
		this.idAgence = adAgence;
		this.lastName = lastName;
		this.firstName = firstName;
		this.cellphone = cellphone;
	}

	
	public Person(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", 0);
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

	public long getCellphone() {
		return cellphone;
	}

	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}

}
