package com.gds.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");//8.0���ϰ汾com.mysql.cj.jdbc.Driver
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
			Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gamedrawsystem?characterEncoding=utf-8", "root", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����ݿ�����");
		return connection;
		}
	public static void closeAll(Connection connection,Statement st,ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(st!= null) st.close();
			if(connection != null) connection.close();
			System.out.println("���ݿ����ӹر�..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
}
