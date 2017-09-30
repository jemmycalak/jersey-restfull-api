package jersey.restfull.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {
	
	//inisialisasi config database
	// PostgreSQL用
//		private static final String DRIVER_NAME = "org.postgresql.Driver";
//		private static final String DB_URL = "jdbc:postgresql:ca";
//		private static final String ID = "postgres";
//		private static final String PASS = "postgres";
	
	// Oracle用
//		private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//		private static final String DB_URL = "jdbc:oracle:thin:@dbserver:1521:xe";
//		private static final String ID = "sys";
//		private static final String PASS = "orcl";
	
	// SQLServer用
//		private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		private static final String DB_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=ca";
//		private static final String ID = "sa";
//		private static final String PASS = "sa";
	
//		MYSQL
	private static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/db_maven";
	private static final String USER_DB= "root";
	private static final String PASSWORD_DB = "";

	//connect to database
	public static Connection getConection() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, USER_DB, PASSWORD_DB);		
		}catch(Exception x){
			System.out.println("Koneksi database bermasalah.");
			throw new RuntimeException(x);
		}
		
	}
	
	//close connection
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException x) {
				throw new RuntimeException(x);
			}
		}
		
	}
	
}
