package com.EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class  EmployeeDetails {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	   	    System.out.println("welcome to Employee Management portal!!!");
	   	
		    System.out.println("Option1: To insert new employee details");
	   	    System.out.println("OPtion2: Show all employee details");
	   	    System.out.println("Option3: Update employee details");
	   	    System.out.println("Option4: Delete employee details");
   	 int option;
	         
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	     //step1:register driver
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     
	     //step2: establish connection
	     
	     con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/empdb1","root","root");
	     //setp3: prepare query and send with statement object
	       
	    do{
	    	 System.out.println("Choose your options");
	    	
	   	    option = sc.nextInt();

	     if(option == 1)
	    		 {
	    	 System.out.println("please enter employee id:");
	 	    int empid = sc.nextInt();
	 	    System.out.println("please enter employee name:");
	 	    String ename = sc.next();
	 	    System.out.println("please enter employee mobil1"
	 	    		+ "enumber:");
	 	    String mobilenumber = sc.next();
	 	    System.out.println("please enter employee dept:");
	 	          String dept = sc.next();
	 	    System.out.println("please enter employee city:");
	 	          String city = sc.next();
	    	 
	    	 String qry = "insert into employee_info values(?,?,?,?,?)";//? is called placeholder
	    	   //step4: create PreparedStatement object
	    	     ps = con.prepareStatement(qry);
	    	     
	    	     //set placeholder values
	    	     ps.setInt(1,empid);
	    	     ps.setString(2, ename);
	    	     ps.setString(3,mobilenumber);
	    	     ps.setString(4, dept);
	    	     ps.setString(5,  city);
	    	     
	    	     int result = ps.executeUpdate();
	    	     System.out.println("Record inserted successfully");
	     }
	    	     else if(option ==2)
	    	     {
	    	    	 
	    	    		 String qry = "select * from employee_info";
	    			   
	    			   //step4: create PreparedStatement object
	    			   ps = con.prepareStatement(qry);
	    			   
	    			   
	    			    rs =  ps.executeQuery();
	    			   
	    			   //step5:process the results
	    			   while(rs.next())
	    			   {
	    			    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
	    			   }
	             }
	     else if(option ==3)
	     {
	    	 
	    	 System.out.println("please enter employee id:");
	 	    int empid = sc.nextInt();
	 	    System.out.println("please enter employee name:");
	 	    String ename = sc.next();
	 	    System.out.println("please enter employee mobilenumber:");
	 	    String mobilenumber = sc.next();
	 	    System.out.println("please enter employee dept:");
	 	          String dept = sc.next();
	 	    System.out.println("please enter employee city:");
	 	          String city = sc.next();
	    	 String qry = "update employee_info set mobilenumber=?,city=? where empid=?";//? is called placeholder
			 //step4: create PreparedStatement object
			   ps = con.prepareStatement(qry);
			   
			   //set placeholder values
			   ps.setString(1,mobilenumber);
			   ps.setString(2, city);
			   ps.setInt(3, empid);
			   
			   
			   int result = ps.executeUpdate();
			   System.out.println("Record updated successfully");
	    		 
	     }
	     else if(option ==4)
	     {
	    	System.out.println("Please enter employee id:");
	    	int empid = sc.nextInt();
	    		 String qry = "delete from employee_info where empid=?";//? is called placeholder
	     ps = con.prepareStatement(qry);
	     
	     //set placeholder values
	     ps.setInt(1,empid);
	     //step4: create PreparedStatement object
	     
	      int result = ps.executeUpdate();
	     System.out.println("Record deleted successfully");
	     }
	    }while(option!=0);
	   
	    
	    }
	     catch (ClassNotFoundException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			  
			    finally
			    {
			     //step6: close jdbc objects in reverse direction
			     if(rs!=null)
			     {
			      try {
			    rs.close();
			   } catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
			     }
			     if(ps!=null)
			     {
			      try {
			    ps.close();
			   } catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
			     }
			     if(con!=null)
			     {
			      try {
			    con.close();
			   } catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			   }
			     }
			    }

	}

}
