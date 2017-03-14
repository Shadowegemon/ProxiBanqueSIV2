package metier;

import java.util.ArrayList;
import java.util.List;

public class Adviser extends Person {

	private List<Client> listOfClient = new ArrayList<>();

	public static final int MAXCLIENT = 10;

	private String login = "maou";
	private String pwd = "maou";

	private static Adviser INSTANCE = null;
	private Adviser(){
		super("", "");
			}
	
	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	// Point d'acces pour l'instance unique du singleton.
	public static Adviser getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Adviser();
		return INSTANCE;
	}
		
	public boolean checkPassword(String nlogin, String npwd) {
		if (login.equals(nlogin) && pwd.equals(npwd)) {
			return true;
		} else {
			return false;
		}
	
	}

	public boolean addClient(Client cl) {
		if (this.listOfClient.size() < MAXCLIENT) {
			this.listOfClient.add(cl);
			return true;
		} else
			return false;

	}

	public boolean isAviableToNewClient() {
		if (this.listOfClient.size() < 10)
			return true;
		else
			return false;
	}

	public List<Client> getListOfClient() {
		return listOfClient;
	}

}
