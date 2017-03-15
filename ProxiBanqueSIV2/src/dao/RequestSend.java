package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import metier.Client;

public class RequestSend {
	public static java.sql.Statement stat = null;
	public static ResultSet rs = null;

	public static void makeStatement(Connection cnx) throws SQLException {
		System.out.println("connection = " + cnx);
		stat = cnx.createStatement();
		System.out.println("stat = " + stat);
	}

	public static void sendRequest(String str) {
		try {
			stat.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("send by statment "+str+" line change ");
	}


}
