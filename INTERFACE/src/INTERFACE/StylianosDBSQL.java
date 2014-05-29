/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package INTERFACE;

//STEP 1. Import required packages
import java.sql.*;
/**
 *
 * @author 
 */
public class StylianosDBSQL {

    /**
     * @param args the command line arguments
     */
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    static final String DB_URL = "jdbc:sqlserver://192.168.0.11\\SMKANA01:1433";

    //  Database credentials
    static final String USER = "smmkana02";
    static final String PASS = "smmkana02";
   
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);

           //STEP 4: Execute a query
           System.out.println("Creating database...");
           stmt = conn.createStatement();

           String sql1 = "INSERT INTO [dbo].[login]([username],[pass])VALUES ('kiriakos','123')";
           //stmt.executeQuery(sql1);
        		   String sql = "SELECT [username],[pass]  FROM [dbo].[login] ";
          
         
        		   rs= stmt.executeQuery(sql);
          
           
           while (rs.next()) {
				// retrieve the columns in any order
				String col2 = rs.getString("username");
				String col1 = rs.getString("pass");
				// printing out a row
				System.out.println(col1 + "," + col2);
			}
           
           
           
           System.out.println("Statement executed successfully...");
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
    
