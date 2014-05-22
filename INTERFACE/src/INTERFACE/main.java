package INTERFACE;

import java.sql.*;

public class main {	 
	static final String JDBCDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String connectionStr =
					"jdbc:sqlserver://Data Source=VAIO;Initial Catalog=Clubs;Integrated Security=True";
	 
	public static void main(String[] args)  {
		
		 try{
			 
			 
			 String userName ="username";
			 String password ="password";
			 
			 
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 Connection conn = DriverManager.getConnection(connectionStr,userName,password);
			 
			 
			
		
			   
			  
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
