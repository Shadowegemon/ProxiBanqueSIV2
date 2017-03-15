package service;

import java.util.List;

import dao.DaoClient;
import metier.BankAccount.etype;
import metier.Client;

/**
 * @author Jonas 
 *
 */
public class ServiceAudit extends SService {

	private static double valueAuditCasual = -5000.0;
	private static double valueAuditEntreprise = -50000.0;
/**
 * Faire un audit pour vérifier les comptes clients débiteurs
 * @param idAg : récupère l'identifiant d'une agence
 */
	public void doAudit(String idAg) {
		List<Client> listClient = DaoClient.getInstance().getClientOfAgence(idAg);

		for (Client client : listClient) {
			double solde = 0.0;
			switch (client.getType()) {
			case CASUAL:
				solde = client.getAccount(etype.CURRENT_ACCOUNT).getSold();
				if (solde < valueAuditCasual)
					System.out.println("Le client " + client.getFirstName() + " " + client.getLastName()
							+ " a un solde de :" + solde);
				break;
			case ENTERPRISE:
				solde = client.getAccount(etype.CURRENT_ACCOUNT).getSold();
				if (solde < valueAuditEntreprise)
					System.out.println("L'entreprise " + client.getFirstName() + " " + client.getLastName()
							+ " a un solde de :" + solde);
				break;
			default:
				System.out.println("Rien ne va plus");
				break;
			}
		}

	}

	/**
	 * Change les valeurs à vérifier pour les comptes
	 * @param vAC : valueAuditCasual
	 * @param vAE : valueAuditEntreprise
	 */
	public void changeValues(double vAC, double vAE) {
		valueAuditCasual = vAC;
		valueAuditEntreprise = vAE;
	}

}
