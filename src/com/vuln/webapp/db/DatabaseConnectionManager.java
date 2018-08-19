package com.vuln.webapp.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

	private Connection connection;
	
	public DatabaseConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}
