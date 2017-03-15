
package service;

import dao.DaoClient;
import metier.BankAccount.etype;
import metier.BankCard;
import metier.CardElectron;
import metier.CardVisa;
import metier.Client;

/**
 * @author Jonas Maëva
 *
 */
public class ServiceCard extends SService {
/**
 * Ajoute une carte au client pour son compte courant
 * @param idCl : identifiant client
 * @param type : type de compt
 */
	public static void addCardToClient(long idCl, BankCard.etype type) {

		Client cl = DaoClient.getInstance().getClientById(idCl);

		if (cl.getAccount(etype.CURRENT_ACCOUNT) != null) {

			switch (type) {
			case VISA:
				cl.AddBankCard(new CardVisa(idCl));
				break;
			case ELECTRON:
				cl.AddBankCard(new CardElectron(idCl));
				break;
			default:
				System.out.println("Vous avez un problème");
				break;
			}

			DaoClient.getInstance().addClient(cl);
		}else SService.sendInfoToclient(idCl, " n'a pas de compte courrant donc on ne peut pas lui assigner de carte ! ");
	}

}
