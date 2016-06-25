package com.szeljic.orm;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private String driver = "";
	private String connectionString = "";
	private String username = "";
	private String password = "";
	
	private Connection connection = null;
	
	public Database(String driver, String connectionString, String username, String password) throws Exception {
		this.driver = driver;
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
		
		this.establishConnection();
	}
	
	public Database(String driver, String connectionString) throws Exception {
		this.driver = driver;
		this.connectionString = connectionString;
		
		this.establishConnection();
	}
	
	private void establishConnection() throws Exception {
		if(this.connectionString == null || this.driver == null || 
				this.connectionString.equals("") || this.driver.equals("")) {
			throw new Exception("Missing connection string or driver");
		}
		Class.forName(this.driver);
		if(this.username != "") {
			this.connection = DriverManager.getConnection(this.connectionString, this.username, this.password);
		} else {
			this.connection = DriverManager.getConnection(this.connectionString);
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
