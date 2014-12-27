
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class dbconnectivity {

	
	public static void main(String[] args) {
		new dbconnectivity().getconnect();
	}
	public  Connection getconnect() {
		Connection con = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager
					.getConnection("jdbc:sqlserver://isecure.csnjecjhiiwy.us-west-2.rds.amazonaws.com\\SQL2012:1433;"
							+ "Database=iSecureDB;User=root;Password=soon1234");
			
		ResultSet rs=	con.createStatement().executeQuery("select * from dbo.EmpInfo");
		
		while(rs.next()){
			System.out.println(rs.getString(1));
		}

		} catch (Exception ae) {
			ae.printStackTrace();
			
		}
		return con;
	}

}
