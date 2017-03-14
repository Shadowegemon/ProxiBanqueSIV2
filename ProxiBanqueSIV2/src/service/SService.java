package service;

import dao.DaoClient;

/**
 * @author Jonas Samuel
 *
 */
public class SService {

	public SService()
	{
		DaoClient.getInstance();
	}

	/**
	 * Envois des informations au client
	 * @param idClient : indentifiant du client
	 * @param info : information sous string 
	 */
	public static void sendInfoToclient(long idClient, String info) {
		System.out.println(" Info client : " + DaoClient.getInstance().getClientById(idClient).getLastName() + " " + info);
	}
}
