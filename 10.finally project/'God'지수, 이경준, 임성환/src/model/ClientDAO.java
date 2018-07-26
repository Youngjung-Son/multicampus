package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ClientDTO;
import util.DBUtil;

public class ClientDAO {
	//모든 고객 검색 
	public static ArrayList<ClientDTO> allSearch() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> data = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from client");
			rset = pstmt.executeQuery();
			data = new ArrayList<ClientDTO>();
			while(rset.next()) {
				data.add(new ClientDTO());
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	
	

	// Client Insert 메소드
	public static boolean insert(ClientDTO newDTO) throws SQLException {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement("insert into client values(?,?,?,?,?,?,?,?,?,?)");
	         pstmt.setString(1, newDTO.getUserId());
	         pstmt.setString(2, newDTO.getPassword1());
	         pstmt.setString(3, newDTO.getKoreanLastName());
	         pstmt.setString(4, newDTO.getKoreanFirstName());
	         pstmt.setString(5, newDTO.getLastName());
	         pstmt.setString(6, newDTO.getFirstName());
	         pstmt.setString(7, newDTO.getDateOfBirth());
	         pstmt.setString(8, newDTO.getGender());
	         pstmt.setString(9, newDTO.getEmail());
	         pstmt.setString(10, newDTO.getRepresentPhoneNumber());
	         
	         int result = pstmt.executeUpdate();
	         if (result == 0) {
	            return false;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;
	      } finally {
	         DBUtil.close(con, pstmt);
	      }

	      return true;

	   }
	
	
	//login 검증 - id/pw 값으로 name 반환
	//select : query
	public static String loginCheck(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select name from"
					+ " client where id=? and pw=?");
			
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
	
	
	//해당 고객만의 정보 수정(id값으로 이름 수정)
	//update : DML
	public static boolean update(String id, String newName) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update client set name=? where id=?");
			
			pstmt.setString(1, newName);
			pstmt.setString(2, id);
			
			int r = pstmt.executeUpdate();//insert.update.delete 실행
			
			if(r != 0) {
				result = true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
}







