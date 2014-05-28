package INTERFACE;

import java.sql.*;

public class main {	 

	//static final String JDBCDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	static final String connectionStr =
					//"jdbc:sqlserver://Data Source=VAIO;Initial Catalog=Clubs;Integrated Security=True";
					
			//		static final String connectionStr =
				//			"jdbc:sqlserver://localhost;database=VAIO;Initial Integrated Security=True";		
	 
	public static void main(String[] args)  {
		
		 try{
			 
			 
			// String userName ="username";
			// String password ="password";
			 
			// String url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MyTest;integratedSecurity=true";
			 String url = "jdbc:sqlserver://VAIO\\MSSQLSERVER; databaseName=MyTest; integratedSecurity=true ";
		
			 
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
