package service;

import java.util.Collection;
import java.util.List;

import dao.DaoClient;
import metier.Adviser;
import metier.Client;

public class ServiceActor {

	
	public static void updateClientToBDD(Client cl) {
		DaoClient.getInstance().addClient(cl);
	}

	/**
	 * Ajout du client dans la base de données, ajout du client dans la liste
	 * des clients d'un conseiller SI en existe de disponible le client reçoit
	 * alors l'identifiant de ce conseiller SINON aucun conseiller ne lui est
	 * attribué
	 * 
	 * @param cl
	 *            = nouveau client
	 */
	public static void addNewClient(Client cl) {
	/*	Adviser adtmp = DAO.getInstance().getAdviserDispo();
		if (adtmp != null) {
			adtmp.addClient(cl);
			cl.setIdAgence(adtmp.getIdAgence());
		}*/
		//cl.setIdAviser(Adviser.current);
		DaoClient.getInstance().addClient(cl);
	}

	/**
	 * Supprime un client de la base de données
	 * 
	 * @param cl
	 */
	public static void removeClient(Client cl) {
		DaoClient.getInstance().removeClient(cl);
	}




	/**
	 * 
	 * @return Retourne un texte présentant les informations importantes du
	 *         client
	 */
	public static List<Client> getAllClient() {
		return DaoClient.getInstance().getClientOfAgence("0");
	}
}
