package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	/**
	 * ajout un client dans la base de données
	 */
	@Override
	public void addClient(Client cl) {
		String str = "insert into CLIENT values(null, '0', '" + cl.getLastName() + "', '" + cl.getFirstName() + "', '"
				+ cl.getCellphone() + "', '" + cl.getAddress() + "', '" + cl.getZipCode() + "', '" + cl.getTown()
				+ "', '" + cl.getOverdraftRate() + "')";
		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);
			RequestSend.stat.executeQuery(str);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();

	}
	/**
	 * supprime le client dans la base de données
	 */

	@Override
	public void removeClient(Client cl) {
		String str = "DELETE FROM `client` WHERE `client`.`idClient` = " + cl.getId();
		try {

			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);
			RequestSend.stat.executeQuery(str);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
	}

	/**
	 * 
	 * @return renvois le client de la base de données depuis son id
	 */
	@Override
	public Client getClientById(Long id) {
		String str = "SELECT * FROM client WHERE client.idClient=" + id;
		Client clret = null;
		ResultSet rs;
		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);
			rs = RequestSend.stat.executeQuery(str);
			rs.next();

			clret = new Client(rs.getInt("idclient"), "0", rs.getString("lastName"), rs.getString("firstName"),
					rs.getString("celphone"), rs.getString("addresse"), rs.getString("zipCode"), rs.getString("town"), rs.getString("email"));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		return clret;
	}

	/**
	 * @deprecated
	 * @param idAg : identifiant de l'agence
	 * @return list des clients par agence
	 */
	public List<Client> getClientOfAgence(String idAg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return la liste de tous les clients
	 */

	public List<Client> getAllClient() {
		List<Client> clList = new ArrayList<>();

		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);

			String str = "SELECT * from CLIENT";
			ResultSet rs = RequestSend.stat.executeQuery(str);
			while (rs.next()) {
				Client tmp = new Client(rs.getLong("idClient"), rs.getString("idAgence"), rs.getString("lastName"),
						rs.getString("firstName"), rs.getString("celphone"), rs.getString("addresse"),
						rs.getString("zipCode"), rs.getString("town"), rs.getString("email"));
				clList.add(tmp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		ConnectionMysql.Closeconnection();
		return clList;
		// return null;
	}

	/**
	 * Modifi le client sur la base de donnée par rapport au client envoyer en
	 * paramettre
	 */
	@Override
	public void updateClient(Client cl) {

		String str = "UPDATE `client` SET `lastName` = '" + cl.getLastName() + "', `firstName` = '" + cl.getFirstName()
				+ "', `addresse` = '" + cl.getAddress() + "', `zipCode` = '" + cl.getZipCode() + "', `town` = '"
				+ cl.getTown() + "', `celphone` = '" + cl.getCellphone() + "', `isRitch` = '" + cl.isClientIsRich()
				+ "', '" + cl.getOverdraftRate() + "' WHERE `client`.`idClient` =" + cl.getId();

		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);
			System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE   bdd mise a jouer tant de ligne : "+RequestSend.stat.executeUpdate(str));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionMysql.Closeconnection();
	}

}
