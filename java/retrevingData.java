package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class retrevingData {
    private static final String userName = "root";
    private static final String password = "Jhansi@123";
    private static final String URL = "jdbc:mysql://localhost:3306/sql_hr";

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary:");
        double salary = sc.nextDouble();
        Connection con = DriverManager.getConnection(URL, userName, password);

        StringBuilder sb = new StringBuilder("SELECT * FROM EMPLOYEES");
        if (salary > 0) {
            sb.append(" WHERE salary >= ? ");
        }

        PreparedStatement smt = con.prepareStatement(sb.toString());
        if (salary > 0) {
            smt.setDouble(1, salary);
        }

        ResultSet rs = smt.executeQuery();
        System.out.println("Employee Details:"+rs);
        while (rs.next()) {
            // Process retrieved data here, for example:
            int employeeId = rs.getInt("employee_id");
            String employeeName = rs.getString("first_name");
            // Print or process the retrieved data as needed
            System.out.println("ID: " + employeeId + ", Name: " + employeeName);
        }
        
        System.out.println("Query executed successfully.");
        con.close();
    }
}
