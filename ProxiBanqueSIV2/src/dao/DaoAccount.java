package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.BankAccount;
import metier.BankAccount.etype;

public class DaoAccount implements IDaoAccount {

	private DaoAccount()
	{
		
	}
	private static DaoAccount INSTANCE = null;

	// Point d'acces pour l'instance unique du singleton.
	public static DaoAccount getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DaoAccount();
		return INSTANCE;
	}
	
	/**
	 * @return renvois la liste de tous les comptes d'un client
	 */
	@Override
	public List<BankAccount> getAllAccountByIdClient(long id) {
		List<BankAccount> baList = new ArrayList<>();
		
		String str = "SELECT * FROM account WHERE account.idclient ="+id;
		try {
			ConnectionMysql.ConnectionToBDD();
			ResultSet rs = RequestSend.stat.executeQuery(str);
			while (rs.next())
			{
				BankAccount tmp = new BankAccount(id, rs.getDouble("sold"), rs.getString("openDate"), etype.valueOf(rs.getString("typeOfAccount")));
				baList.add(tmp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		return baList;
	}

	/**
	 * Récupère l'id du compt et la somme qu'il doit mettre à la place
	 */
	@Override
	public void updateAccountByid(long id, double money) {
		String str = "UPDATE account SET sold = '"+money+"' WHERE account.idAccount ="+id;

		try {

			ConnectionMysql.ConnectionToBDD();
			RequestSend.stat.executeQuery(str);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		
	}
	
	/**
	 * 
	 * @return renvois la liste de tous les comptes existant dans la base de données.
	 */

	@Override
	public List<BankAccount> getAllAccount() {
		List<BankAccount> baList = new ArrayList<>();
		
		String str = "SELECT * FROM `account'";
		try {
			ConnectionMysql.ConnectionToBDD();
			ResultSet rs = RequestSend.stat.executeQuery(str);
			while (rs.next())
			{
				BankAccount tmp = new BankAccount(rs.getLong("idclient"), rs.getDouble("sold"), rs.getString("openDate"), etype.valueOf(rs.getString("typeOfAccount")));
				baList.add(tmp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		return baList;
	}

	/**
	 * @return revois un compt par rapport à son identifiant
	 */
	@Override
	public BankAccount getAccountById(long id) {
		String str = "SELECT * FROM account WHERE idAccount="+id;

		try {
			ConnectionMysql.ConnectionToBDD();
			System.out.println("test stat = "+RequestSend.stat);
			ResultSet rs = RequestSend.stat.executeQuery(str);
			rs.next();
			BankAccount retba = new BankAccount(rs.getLong("idclient"), rs.getDouble("sold"),rs.getString("openDate"),etype.valueOf(rs.getString("typeOfAccount")));
			System.out.println("DaoAccount getAccountById ret = "+retba);
			ConnectionMysql.Closeconnection();
			return retba;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		return null;
	}

	@Override
	public void removeAccountById(BankAccount ba) {
		// TODO Auto-generated method stub
		
	}

}
