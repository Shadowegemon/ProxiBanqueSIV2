package metier;

import java.util.ArrayList;
import java.util.List;

import service.ServiceActor;


public class Adviser extends Person{

	private List<Client> listOfClient = new ArrayList<>();
	
	public static final int MAXCLIENT = 10;
	public static Adviser current;
	
	public Adviser(long id, String idAgence, String lastName, String firstName, long cellphone) {
		super(id, idAgence, lastName, firstName, cellphone);
		
		
	}
	public Adviser(String idAgence, String lastName, long cellphone)
	{
		this(0, idAgence, lastName, "", cellphone);
		current = this;
	}
	

	public Adviser(String idAgence, String lastName)
	{
		
		this(0, idAgence, lastName, "", 0);
	}
	
	public boolean addClient(Client cl)
	{
		if (this.listOfClient.size() < MAXCLIENT)
		{
			this.listOfClient.add(cl);
			return true;
		}
		else
			return false;
			
	}
	
	public boolean isAviableToNewClient()
	{
		if (this.listOfClient.size()<10)
			return true;
		else
			return false;
	}
	public List<Client> getListOfClient() {
		return listOfClient;
	}
	
	

}
