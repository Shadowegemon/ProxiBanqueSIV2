package dao;

import java.util.List;

import metier.Client;

public class DaoClient implements IDaoClient {

	
	private DaoClient() {

	}

	// Instance unique non préinitialisée.
	private static DaoClient INSTANCE = null;

	// Point d'acces pour l'instance unique du singleton.
	public static DaoClient getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DaoClient();
		return INSTANCE;
	}

	
	@Override
	public void addClient(Client cl) {
		ConnectionMysql.ConnectionToBDD();
		
		

	}

	@Override
	public void removeClient(Client cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Client> getClientOfAgence(String idAg) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Client> getAllClient() {
		return RequestSend.getAllClient();
		//return null;
	}


}
