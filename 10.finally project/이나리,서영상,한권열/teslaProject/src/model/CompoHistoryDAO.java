package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.CompoHistoryDTO;
import model.domain.CustomerDTO;
import util.DBUtil;

public class CompoHistoryDAO {
	
	//모든 부품 교체내역 검색
	public static ArrayList<CompoHistoryDTO> allCompoHist(String cust_email, String compo_name) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		String serialno = null;
		ArrayList<CompoHistoryDTO> data = null;
		
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select serialno from customer where cust_email=?");
			pstmt.setString(1, cust_email);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				serialno = rset.getString(1);
				
				pstmt2 = con.prepareStatement("select serialno, compo_name, replacedate from compohistory where serialno=? and compo_name=?");
				pstmt2.setString(1, serialno);
				pstmt2.setString(2, compo_name);
				rset2 = pstmt2.executeQuery();
				data = new ArrayList<CompoHistoryDTO>();
					
				while(rset2.next()) {
					data.add(new CompoHistoryDTO(rset2.getString(1), rset2.getString(2), rset2.getString(3)));
				}
			}
			
			
				
		}finally {
			DBUtil.close(con, pstmt, rset);
			DBUtil.close(con, pstmt2, rset2);
		}
		return data;
	}
	
	
	//부품 이력 추가
	public static boolean insertCompoHist(String cust_email, String compo_name, String replacedate) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String serialno = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select serialno from customer where cust_email=?");
			pstmt.setString(1, cust_email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				serialno = rs.getString(1); 
			}
			pstmt2 = con.prepareStatement("insert into compohistory(hist_idx, serialno, compo_name, replacedate) values(SEQ_COMPOHISTORY_HIST_IDX.nextval,?,?,?)");
			pstmt2.setString(1, serialno);
			pstmt2.setString(2, compo_name);
			pstmt2.setString(3, replacedate);
			
			int result = pstmt2.executeUpdate();
			
			if(result != 0) {
				return true;
			}
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt,rs);
			DBUtil.close(con, pstmt2,rs);
		}
		
		return false;
	}
	
	
	//부품 이력 조회
	
	

}
