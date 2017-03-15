package service;

import dao.DaoClient;

/**
 * @author Jonas Maëva
 *
 */
public class SService {

	public SService()
	{
		DaoClient.getInstance();
	}

	/**
	 * Envoi des informations au client
	 * @param idClient : indentifiant du client
	 * @param info : informations en string 
	 */
	public static void sendInfoToclient(long idClient, String info) {
		System.out.println(" Info client : " + DaoClient.getInstance().getClientById(idClient).getLastName() + " " + info);
	}
}
