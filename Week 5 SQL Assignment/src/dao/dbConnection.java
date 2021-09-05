package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

	
	private final static String URL = "jdbc:mysql://localhost:3306/plants";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "thisis10ch";
	private static Connection connection;
	private static dbConnection instance;
	
	
	
	private dbConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new dbConnection(connection);
				System.out.println("Connection Successful!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dbConnection.connection;
	}

	
	}

