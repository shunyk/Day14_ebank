package com.shunyk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	
	public static Connection dbConnect() throws Exception {
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@211.238.142.26:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception{
		st.close();
		con.close();
	}
	
	public static void disConnect(PreparedStatement st, Connection con, ResultSet rs) throws Exception{
		rs.close();
		st.close();
		con.close();
	}
	
	public static void disConnect(ResultSet rs) throws Exception{
		rs.close();
	}
	
}
