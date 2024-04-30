package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class ExampleOfJDBCincremetingHike {
	 private static final String userName = "root";
	    private static final String password = "Jhansi@123";
	    private static final String URL = "jdbc:mysql://localhost:3306/sql_hr";


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the HikeIncrement(%):");
		int hike = sc.nextInt();
		Connection con = DriverManager.getConnection(URL,userName,password);
		String res = "UPDATE EMPLOYEES SET SALARY = (SALARY+(SALARY*?)/100)";
		 PreparedStatement smt = con.prepareStatement(res);
		 smt.setDouble(1, hike);
		 smt.executeUpdate();
		 System.out.println("Update Completed....");
	     

	}

}
