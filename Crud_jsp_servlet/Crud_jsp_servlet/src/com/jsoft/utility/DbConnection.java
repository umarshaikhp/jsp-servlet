package com.jsoft.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/registerCrud";
	private static String USER = "root";
	private static String PASSWORD = "izhar";

	
	  public static void main(String[] args) {
	 System.out.println(get_connection()); }
	 
	public static Connection get_connection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
		if (ps != null) {
			ps.close();
			ps = null;
		}
	}
	
	public static void closeConnectionRs(Connection conn, PreparedStatement ps,ResultSet rs) throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
		if (ps != null) {
			ps.close();
			ps = null;
		}
		if(rs!=null){
			rs.close();
			rs=null;
		}
	}
}
