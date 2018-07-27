package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.CompoStateDTO;
import model.domain.CustomerDTO;
import util.DBUtil;

public class CompoStateDAO {
	
	//고객부품정보 입력
	public static boolean insertCompoInfo(String cust_email) throws SQLException{
			
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
			pstmt2 = con.prepareStatement("insert into compostate(state_idx, compo_name, replacedate, duedate, serialno) (select seq_compostate_state_idx.nextval as state_idx, compo_name, saledate as replacedate, duedate, serialno"+
			" from (select compo_name, saledate, to_char(add_months(saledate,compo_life),'yyyy.mm.dd') as duedate, serialno from carinfo, compolist where serialno=?))");
			pstmt2.setString(1, serialno);
			
			int result = pstmt2.executeUpdate();
			
			if(result != 0) {
				return true;
			}
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt,rs);
		}
		
		return false;
	}

	
	//고객 모든 부품정보 조회
	public static ArrayList<CompoStateDTO> allCompoState(String cust_email) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		String serialno = null;
		
		ArrayList<CompoStateDTO> data = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select serialno from customer where cust_email=?");
			pstmt.setString(1, cust_email);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				serialno = rset.getString(1);
				data = new ArrayList<CompoStateDTO>();
				
				pstmt2 = con.prepareStatement("select compo_name, replacedate, duedate, serialno, ((duedate-sysdate)/(duedate-replacedate))*100 from compostate where serialno=?");
				pstmt2.setString(1, serialno);
				rset2 = pstmt2.executeQuery();
				
				while(rset2.next()) {
					data.add(new CompoStateDTO(rset2.getString(1), rset2.getString(2), rset2.getString(3), rset2.getString(4),rset2.getInt(5)));
				}
				
				for(int i=0; i<data.size(); i++) {
					if(data.get(i).getPercent()<0) {
						data.get(i).setPercent(0);
					}
				}
			
			}
			
			
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	
	//부품 교체(날짜 수정)
	public static boolean replaceCompo(String cust_email, String compo_name, String replacedate) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		boolean result = false;
		
		String serialno = null;
		int compo_life = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select serialno from customer where cust_email=?");
			pstmt.setString(1, cust_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				serialno = rs.getString(1);
				System.out.println(serialno);
				pstmt2 = con.prepareStatement("select compo_life from compolist where compo_name=?");
				pstmt2.setString(1, compo_name);
				rs2 = pstmt2.executeQuery();
				if(rs2.next()) {
					compo_life = rs2.getInt(1);
					System.out.println(compo_life);
					pstmt3 = con.prepareStatement("update compostate set replacedate=?, duedate=add_months(?,?) where serialno=? and compo_name=?");
					pstmt3.setString(1, replacedate);
					pstmt3.setString(2, replacedate);
					pstmt3.setInt(3, compo_life);
					pstmt3.setString(4, serialno);
					pstmt3.setString(5, compo_name);
					
					int r = pstmt3.executeUpdate();
					if(r != 0) {
						result = true;
					}
				}
				
			}
			
		}catch(SQLException e) {
			throw e;
		
		}finally {
			DBUtil.close(con, pstmt,rs);
			DBUtil.close(con, pstmt2,rs2);
		}
		return result;
	}
	
}
