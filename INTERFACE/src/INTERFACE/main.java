package INTERFACE;

import java.sql.*;

public class main {	 


	 
	public static void main(String[] args)  {
		
		// String url = "jdbc:sqlserver://VAIO\\MSSQLSERVER; databaseName=MyTest; integratedSecurity=true ";
		String url = " jdbc:sqlserver://VAIO;databaseName=MyTest;integratedSecurity=true";
		// String url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MyTest;integratedSecurity=true";
			
		// String url= "jdbc:sqlserver://VAIO;databaseName=MyTest;integratedSecurity=true";
		 
		try{
			 
			 
			 
			 
			// String userName ="username";
			// String password ="password";
			 
			
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
		
			 Connection conn = DriverManager.getConnection(url);
			 			  
			  
				if (conn != null) 
				    System.out.println("Connected");					
				
				System.out.println("Hello world");
		 }//try
		 
		 
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
			
		
		
		
		
		
	}

}//main
