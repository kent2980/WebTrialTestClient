package com.trial.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

public enum DataBaseConnect implements AutoCloseable{
	INSTANCE;
	public static DataBaseConnect getInstance() {
		return INSTANCE;
	}
	
	private static Connection connection;

	public synchronized static Connection getConnection() throws SQLException,NamingException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバをロードできません");
			e.printStackTrace();
		}
		try(Connection connection = DataBaseConnect.connection){
			if(DataBaseConnect.connection == null || DataBaseConnect.connection.isClosed())
				DataBaseConnect.connection = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/java_se8_gold?autoReconnect=true&useSSL=false", "root", "kent6839");
		}
		return connection;
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws Exception {
		return getConnection().prepareStatement(sql);
	}
	
	public void commit() throws SQLException {
		try(Connection connection = DataBaseConnect.connection){
			DataBaseConnect.connection.commit();
		}
	}
	
	public void rollback() throws SQLException {
		try (Connection connection = DataBaseConnect.connection){
			DataBaseConnect.connection.rollback();
		}
	}
	@Override
	public void close() throws Exception {
		try(Connection connection = DataBaseConnect.connection){
			DataBaseConnect.connection.close();
		}
	}

	
}
