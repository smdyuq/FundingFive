package kr.co.green.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
   //   DB 연결
   private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";       
   private static final String USER = "guestgreen";
   private static final String PWD = "1234";
   private Connection con;
   
   // DB 연결해주는 메서드
   public Connection connDB() {
	    try {
	        System.out.println("Connecting to the database...");
	        Class.forName(DRIVER);
	        con = DriverManager.getConnection(URL, USER, PWD); 
	        System.out.println("Connected to the database.");
	        return con;
	    } catch (Exception e) {
	        System.err.println("Failed to establish a database connection.");
	        e.printStackTrace();
	        return null;
	    }
	}
}

