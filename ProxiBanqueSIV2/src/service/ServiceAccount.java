package service;

import dao.DaoClient;
import metier.AccountCurrent;
import metier.AccountSaving;
import metier.BankAccount;
import metier.BankAccount.etype;
import metier.Client;

/**
 * @author Jonas Samuel
 *
 */
public class ServiceAccount {

	/**
	 * Ajoute un compte au client selon son type. 
	 * @param idClient : client identifiant
	 * @param type : type de compt
	 * @param startSold : montant à la création du compte, ne peux être négatif
	 */
	public static void addAccountToClient(long idClient, BankAccount.etype type, long startSold) {
		if (startSold < 0)
		{
			SService.sendInfoToclient(idClient, " vous ne pouvez rentrer un sold négatif");
			startSold = 0;
		}
		
		switch (type) {
		case CURRENT_ACCOUNT:
			DaoClient.getInstance().getClientById(idClient).addBankAccount(new AccountCurrent(idClient, startSold, "today"));
			break;
		case SAVING_ACCOUNT:
			DaoClient.getInstance().getClientById(idClient).addBankAccount(new AccountSaving(idClient, startSold, "today"));
			break;

		}
	}

	/**
	 * Suppirme un client de la base de donner.
	 * @param idClient : client identifiant
	 * @param type : type de compte
	 */
	public static void removeAccountToClient(long idClient, BankAccount.etype type) {
		Client tmp = DaoClient.getInstance().getClientById(idClient);
		tmp.removeBankAccount(tmp.getAccount(type));

	}

	/**
	 * Mets ajour le découvert d'un compte
	 * @param idClient : client identifiant
	 * @param newOverdraft : nouvel valeur
	 */
	public static void updateOverdrawToClient(long idClient, long newOverdraft) {
		DaoClient.getInstance().getClientById(idClient).setOverdraftRate(newOverdraft);
	}

/**
 * Effecture transèfe de sold ddu compte host au compt dest
 * @param host : compte débiteur
 * @param dest : compt créditeur
 * @param sold : somme
 */
	public static void transferAccoutToAccount(BankAccount host, BankAccount dest, long sold) {
		
			host.setSold(-sold);
			dest.setSold(sold);
			if (!checkRich(host))
				DaoClient.getInstance().getClientById(dest.getIdClient()).setClientIsRich(false);
			if (!checkOverdraft(dest))
			{
				if(checkRich(dest))
					DaoClient.getInstance().getClientById(dest.getIdClient()).setClientIsRich(true);
			}
			else
				SService.sendInfoToclient(host.getIdClient(), "Carfull you still overdraw , sold : "+dest.getSold());
			
		 if (!checkOverdraft(host))
			SService.sendInfoToclient(host.getIdClient(), "Carfull you don't have enought money to make a transfert sold : "+host.getSold());
	}

	/**
	 * Vérification du solde du compte, est il à découvert
	 * @param myAccount : compte à vérifier
	 * @return  vrais si à découvert, faux si pas à découvert
	 */
	public static boolean checkOverdraft(BankAccount myAccount) {
		if (myAccount.getSold()  > DaoClient.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate())
			return false;
		return true;
	}

	/**
	 * Vérification du solde pour savoir s'il est riche
	 * @param myAccount : compte à vérifier
	 *  @return vrais si le client a plus de 500000, faux si le client à moins de 500000
	 */
	public static boolean checkRich(BankAccount myAccount) {
		
		double tmpsold = myAccount.getSold();  
		if (myAccount.getType() == etype.CURRENT_ACCOUNT)
		{
			if (DaoClient.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.SAVING_ACCOUNT) != null)
				tmpsold += DaoClient.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.SAVING_ACCOUNT).getSold();
		}
		else if (myAccount.getType() == etype.SAVING_ACCOUNT)
		{
			if (DaoClient.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.CURRENT_ACCOUNT) != null)
				tmpsold += DaoClient.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.CURRENT_ACCOUNT).getSold();
			
		}
			
		
		if (tmpsold < 500000) // /!\ ATTENTION CHANGE TO STAITC VARIABLE
			return false;
		return true;
	}

}
