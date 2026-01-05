package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username="root";
	private static final String password="tiger";
	
public static Connection getConnection()throws SQLException{
	return DriverManager.getConnection(url,username,password);
}

}
