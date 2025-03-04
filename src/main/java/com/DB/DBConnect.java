package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	public static Connection getConn()
	{
	    final String host = "jdbc:mysql://localhost:3306/movie_app";
	    final String username = "root";
	    final String password = "******";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(host, username, password);
		}
		catch(Exception e){
		e.printStackTrace();
		}
		return conn;
	}

}
