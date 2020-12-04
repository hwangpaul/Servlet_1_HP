package com.choa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnect() throws Exception{
	//1. DB 연결 정보 
		String user = "hr";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		System.out.println("드리이버 로딩 성공");
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
		
		
		
		
	}

}
