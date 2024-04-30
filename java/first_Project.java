package com.java;

import java.sql.DriverManager;
import java.sql.ResultSet;

//import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class first_Project {
   
	private static final String Select_SQL = "SELECT * FROM book1 WHERE book_id = 3";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//step:1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2: get DB connection
	   java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjdb","root","Jhansi@123");
	   System.out.println(con);
	   
	   //Step-3: create Statement
	  java.sql.Statement stmt =  con.createStatement();
	  
	  //step-4: Execute Query
	 ResultSet rs  = stmt.executeQuery(Select_SQL);
	 
	 //Step-5: Process Result
	 System.out.println("Record the count::"+rs);
	 
	 while(rs.next()) {
		 int book_id = rs.getInt("book_id");
		 String name = rs.getString("book_name");
		 String author = rs.getString("author_name");
		 System.out.println(book_id);
		 System.out.println(name);
		 System.out.println(author);
		 
		 
	 }
	 //System.out.println("No record found");
	 
	
	 //Step-6: close connection
	 con.close();

	}

}


