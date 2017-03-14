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

	public static Boolean ConnectionToBDD() throws ClassNotFoundException, SQLException {


			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			
			
			connection = DriverManager.getConnection( urlBdd, user, password );
			

		return true;
	}
	
	public static void Closeconnection()
	{
			
		try {
			if (connection.isValid(0))
				connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
