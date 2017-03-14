package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import metier.Client;

public class RequestSend {
	public  static java.sql.Statement stat = null; 
    private static ResultSet rs = null;
    
    public static void makeStatement(Connection cnx)
    {
        try {
			stat = cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public static void sendRequest(String str)
    {
        try {
			stat.executeUpdate(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //  System.out.println("send by statment "+str+"  line change ");
    }
    
    public static List<Client> getAllClient()
    {
    	List<Client> clList = new ArrayList<>();
    	String str = "SELECT * from client";
    	
    	try {
			rs = stat.executeQuery(str);

	        while (rs.next())
	        {
	            Client tmp = new Client(rs.getLong("idClient"), rs.getString("idAgence"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("celphone"), rs.getString("addresse"), rs.getString("zipCode"), rs.getString("town"));
	            clList.add(tmp);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return clList;
    }
    
    
}
