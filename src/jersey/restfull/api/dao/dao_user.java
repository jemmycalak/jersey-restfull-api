package jersey.restfull.api.dao;
import java.sql.*;
import java.util.*;

import jersey.restfull.api.model.*;
import jersey.restfull.api.connection.*;


public class dao_user {
	
	private static final String DELETE = "DELETE FROM users WHERE user_id=?";
	private static final String FIND_ALL = "SELECT * FROM users ORDER BY id_user";
	private static final String FIND_BY_ID = "SELECT * FROM users where user_id=?";
	private static final String INSERT = "INSERT INTO users (user_nm, user_notelp) VALUES (?, ?)";
	private static final String UPDATE = "UPDATE users SET user_nm=?, user_notelp=? WHERE user_id=?";	
	
	
	public static List<user_object> findAll(){
		
		Connection conn = null;
		PreparedStatement stmn =null;
		List<user_object> userList = new ArrayList<user_object>();
		ResultSet rs;
		
		try {
			conn = db_connection.getConection();
			stmn = conn.prepareStatement(FIND_ALL);
			rs=stmn.executeQuery();
			
			while(rs.next()) {
				user_object object=new user_object();
				object.setName(rs.getString("user_nm"));
				object.setNotelp(rs.getInt("user_notelp"));
				
				//masukan ke list
				userList.add(object);
			}
			
			
			
		}catch(SQLException x) {
			throw new RuntimeException(x);
		}finally {
			db_connection.closeConnection(conn);
//			db_connection.closeConnection(stmn);
		}
		
		return userList;
	}

}
