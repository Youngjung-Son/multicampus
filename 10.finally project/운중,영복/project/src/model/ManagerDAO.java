package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.domain.ManagerDTO;
import util.DBUtil;

public class ManagerDAO {
	
	public static String loginCheck(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select name from manager where id = ? and password = ?");
			//존재하는 이름이 넘어가거나, 이름이 넘어가지 않거는 오류가 발생하거나, 없거나
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				name = rset.getString(1);
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return name;
		
		
	}
}
