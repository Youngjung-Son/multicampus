package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Connection 객체 반환 메소드
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tesla", "tesla");
	}
	
	
	//select문 자원 반환 - Connection, Statement,ResultSet
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//DML 자원 반환 - Connection, Statement
		public static void close(Connection con, Statement stmt) {
			try {
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
