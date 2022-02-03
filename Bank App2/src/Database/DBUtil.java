package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
public static Connection con;
	
	public static Connection getConnection() throws Exception
	{
		if(con==null||con.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			return con;
		}
		return con;		
		}
}
