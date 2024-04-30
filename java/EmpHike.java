package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpHike {
		 private static final String userName = "root";
		 private static final String password = "Jhansi@123";
		 private static final String URL = "jdbc:mysql://localhost:3306/sql_hr";
		 private static final String SELECT_SQL = "SELECT * FROM EMPLOYEES";
		 private static final String res = "UPDATE EMPLOYEES SET SALARY = ? WHERE EMPLOYEE_ID = ?";


	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the hike(%):");
		double hike = sc.nextDouble();
		Connection con = DriverManager.getConnection(URL,userName,password);
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(SELECT_SQL);
		PreparedStatement psmt = con.prepareStatement(res);
		while(rs.next()) {
			int id = rs.getInt("EMPLOYEE_ID");
			double EmpSalary = rs.getDouble("SALARY");
			double newSalary  = EmpSalary+(EmpSalary*hike)/100;
			psmt.setDouble(1, newSalary);
			psmt.setInt(2, id);
			psmt.executeUpdate();
			
		}
		System.out.println("Update completed....");
		con.close();
		
	}
	

}
