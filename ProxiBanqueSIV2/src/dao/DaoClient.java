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

	
	@Override
	public void addClient(Client cl) {
		String str = "insert into CLIENT values(null, '0', '"+cl.getLastName()+"', '"+cl.getFirstName()+"', '"+cl.getCellphone()+"', '"+cl.getAddress()+"', '"+cl.getZipCode()+"', '"+cl.getTown()+"', '"+cl.getOverdraftRate()+"')";
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

	@Override
	public void removeClient(Client cl) {
		String str = "DELETE FROM `client` WHERE `client`.`idClient` = "+cl.getId();
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

	@Override
	public Client getClientById(Long id) {
		String str = "SELECT * FROM client WHERE client.idClient="+id;
		Client clret = null;
		ResultSet rs;
		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);
			rs = RequestSend.stat.executeQuery(str);
			rs.next();
			
			 clret = new Client(rs.getInt("idclient"), "0", rs.getString("lastName"), rs.getString("firstName"), rs.getString("celphone"), rs.getString("addresse"), rs.getString("zipCode"), rs.getString("town"));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionMysql.Closeconnection();
		return clret;
	}


	public List<Client> getClientOfAgence(String idAg) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Client> getAllClient() {
		List<Client> clList = new ArrayList<>();

		try {
			ConnectionMysql.ConnectionToBDD();
			RequestSend.makeStatement(ConnectionMysql.connection);

			String str = "SELECT * from CLIENT";
			RequestSend.rs = RequestSend.stat.executeQuery(str);
			while (RequestSend.rs.next()) {
				Client tmp = new Client(RequestSend.rs.getLong("idClient"), RequestSend.rs.getString("idAgence"), RequestSend.rs.getString("lastName"),
						RequestSend.rs.getString("firstName"), RequestSend.rs.getString("celphone"), RequestSend.rs.getString("addresse"),
						RequestSend.rs.getString("zipCode"), RequestSend.rs.getString("town"));
				clList.add(tmp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		ConnectionMysql.Closeconnection();
		return clList;
		//return null;
	}

	/**
	 * Modifi le client sur la base de donnée par rapport au client envoyer en paramettre
	 */
	@Override
	public void updateClient(Client cl) {

		String str = "UPDATE `client` SET `lastName` = '"+cl.getLastName()+"', `firstName` = '"+cl.getFirstName()+"', `addresse` = '"+cl.getAddress()+"', `zipCode` = '"+cl.getZipCode()+"', `town` = '"+cl.getTown()+"', `celphone` = '"+cl.getCellphone()+"', `isRitch` = '"+cl.isClientIsRich()+"', '"+cl.getOverdraftRate()+"' WHERE `client`.`idClient` ="+cl.getId();

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


}
