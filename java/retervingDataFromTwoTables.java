package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class retervingDataFromTwoTables {
	private static final String userName = "root";
	private static final String password = "Jhansi@123";
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String INSERT_EMP = "INSERT INTO emp VALUES(?,?,?)";
	private static final String EMP_ADDRESS = "INSERT INTO emp_address VALUES(?,?,?,?)";

	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(URL,userName,password);
		con.setAutoCommit(false);
		
	try {
		PreparedStatement smt = con.prepareStatement(INSERT_EMP);
		smt.setInt(1, 104);
		smt.setString(2, "Prajwal");
		smt.setInt(3, 40000);
		
		smt.executeUpdate();
		
	    smt = con.prepareStatement(EMP_ADDRESS);
		smt.setString(1, "Bangalore");
		smt.setString(2, "Karnatak");
		smt.setString(3, "IND");
		smt.setInt(4, 104);
	
		smt.executeUpdate();

		con.commit();


		System.out.println("Records inserted..........");

	}catch(Exception e) {


		System.out.println("Transaction rollBacked.......");
		con.rollback();

	}
	con.close();
		
	}
	

}
