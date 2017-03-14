package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import com.mysql.jdbc.Connection;

public class ConnectionMysql {
	public static java.sql.Connection connection;
	private static String urlBdd = "jdbc:mysql://localhost:3306/proxibanquesiv2";
	private static String user = "root";
	private static String password ="";

	public static Boolean ConnectionToBDD() {

		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection( urlBdd, user, password );
			
			RequestSend.makeStatement(connection);
		} catch (ClassNotFoundException | SQLException e) {
			
			return false;
			/* Gérer les éventuelles erreurs ici. */
		}finally {
		    if ( connection != null )
		        try {
		            /* Fermeture de la connexion */
		        	connection.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}

		return true;
	}
	
	public static void Closeconnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
