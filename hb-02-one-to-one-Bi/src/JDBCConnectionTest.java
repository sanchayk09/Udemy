
import java.sql.*;

public class JDBCConnectionTest {
	 
	 public static void main(String[] args)
	 {
		 try
		 {
			 String username="sa";
			 String password="asdqwkhbe123." ;
		             //driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		      String url="jdbc:sqlserver://DESKTOP-NDFP9CJ\\SA:1433;databaseName=hb_student_tracker";
			 Connection con=DriverManager.getConnection(url, username, password);
			 if(con!=null)
				 System.out.println("DONE");
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
	 }
	  
}
