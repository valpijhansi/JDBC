package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class PreparedStatementEx {
	private static final String userName = "root";
	private static final String password = "Jhansi@123";
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
//	private static final String INSERT_SQL = "INSERT INTO STUDENTS VALUES(?,?,?)";
	private static final String SELECT_DATA = " UPDATE STUDENTS SET VALUES ID = '104',NAME = 'HARITHA' WHERE ADDRESS = 'KADAPS'";

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
//     Scanner sc = new Scanner(System.in);
//     System.out.println("Enter the id:");
//     int id = sc.nextInt();
//     
//     System.out.println("Enter the name:");
//     String name = sc.next();
//     
//     System.out.println("Enter the Address:");
//     String address = sc.next();
//     
//     System.out.println("Enter the phone_No:");
//     String number = sc.next();
//     
     Connection con = DriverManager.getConnection(URL,userName,password);
     
//     PreparedStatement stm = con.prepareStatement(INSERT_SQL);
//     
//     stm.setInt(1,id);
//     stm.setString(2, name);
//     stm.setString(3, address);
////     stm.setString(4, number);
//     
//     int res = stm.executeUpdate();
//     System.out.println("Rows effected::"+res);
//     
     
     Statement stmt = (Statement) con.createStatement();
     ResultSet ans = stmt.executeQuery(SELECT_DATA);
     System.out.println(ans);
  
     
     con.close();
     
     
     
   
   
   


	}

}
