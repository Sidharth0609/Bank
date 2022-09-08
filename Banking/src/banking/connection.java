package banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;
	 public static Connection getConnection()
	    {
	        try {               
	            String oracleJDBCDriver = "oracle.jdbc.driver.OracleDriver"; 
	            String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            String user = "System";       
	            String pass = "12345678"; 
	            Class.forName(oracleJDBCDriver);
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	        }
	        return con;
	    }
}
