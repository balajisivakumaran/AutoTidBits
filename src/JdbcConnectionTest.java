import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 */

/**
 * @author Sairam
 *
 */
public class JdbcConnectionTest {
	public static void main(String[] argrs) throws SQLException {
		
		//jdbc:sqlserver://localhost;user=MyUserName;password=*****;
		Connection dbConnection = null;
		
		try {
			String dbserver = "jdbc:sqlserver://DESKTOP-ORQC6V7;databaseName=Qadbt;";//integratedSecurity=true;
			
			Properties info = new Properties();
			
			info.put("Login", "systestuser");
			
			info.put("Password", "Password00");
			
			String user = "systestuser";
			
			String password = "Password00";
			
			dbConnection = DriverManager.getConnection(dbserver, user,password);
			
			if(dbConnection != null) {
				
				System.out.println("Sucessfully connected to database");
			}
		}
			catch(SQLException e)
			{
				
				System.out.println("An error has occured while connecting");
				
				e.printStackTrace();
				
			}
			
		
		
		
		Statement cs= dbConnection.createStatement();
		
		ResultSet result = cs.executeQuery("select * from Employeeinfo where id =1");
		
		System.out.println("Query executed");
		
	    while (result.next())
	    {
	        String name=result.getString("employeename");

	        System.out.println(name);
	    }
		
		

	}
}
