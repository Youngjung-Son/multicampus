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
	
	
	
	//Connection ��ü ��ȯ �޼ҵ�
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "manager");
	}
	
	//select�� �ڿ� ��ȯ - Connection, Statement, ResultSet
	public static void close(Connection con, Statement stmt, ResultSet rs){
		try {
			if(rs != null) {
				rs.close();
				rs=null;
			}
			if(stmt != null) {
				stmt.close();
				stmt=null;
			}
			if(con != null) {
				con.close();
				con=null;
			}
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	//dml �ڿ� ��ȯ----? �ڽ� Ŭ����????
	public static void close(Connection con, Statement stmt){
		try {
			
			if(stmt != null) {
				stmt.close();
				stmt=null;
			}
			if(con != null) {
				con.close();
				con=null;
			}
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

