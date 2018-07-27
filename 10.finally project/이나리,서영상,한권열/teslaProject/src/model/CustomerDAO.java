package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.domain.CustomerDTO;
import util.DBUtil;

public class CustomerDAO {
	
	//회원가입
	public static boolean register(CustomerDTO customer) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("INSERT INTO customer(cust_idx, cust_email, cust_name, cust_pw, serialno) VALUES(seq_customer_cust_idx.nextval,?,?,?,?)");
			pstmt.setString(1, customer.getCust_email());
			pstmt.setString(2, customer.getCust_name());
			pstmt.setString(3, customer.getCust_pw());
			pstmt.setString(4, customer.getSerialno());
			
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				return false;
			}
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt);
		}
		
		return true;
	}
	
	//로그인
public static String login(String email, String pw) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cust_name = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select cust_name from customer where cust_email=? and cust_pw =?");
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cust_name = rs.getString(1); 
			}
			
			
		}catch(SQLException e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt,rs);
		}
		
		return cust_name;
	}


	//시리얼 등록
	public static boolean serialRegister(String cust_email, String serialno) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		boolean result = false;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select serialno from carinfo where ? in (carinfo.serialno) and certificate=0");
			pstmt.setString(1, serialno);
			
			int r = pstmt.executeUpdate();	//insert, update, delete 실행메소드
			
			if(r != 0) {
				pstmt2 = con.prepareStatement("update customer set serialno=? where cust_email=?");
				pstmt2.setString(1, serialno);
				pstmt2.setString(2, cust_email);
				int r2 = pstmt2.executeUpdate();
				
				if(r2 != 0) {
					pstmt3 = con.prepareStatement("update carinfo set certificate=1 where serialno=?");
					pstmt3.setString(1, serialno);
					pstmt3.executeUpdate();
					
					result = true;
				}else {
					result = false;
				}
				
				
			}else {
				result = false;
			}
			
		}catch(Exception e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	
	//마이페이지
	public static CustomerDTO myPage(String cust_email) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CustomerDTO myInfo = null;
		
		String imgPath = null;	//사진경로
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select distinct cust_name, cust_email, cust_pw, modelname, customer.serialno, carinfo.saledate from customer, carinfo where cust_email=? and customer.serialno=carinfo.serialno");
			pstmt.setString(1, cust_email);
			
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				myInfo = new CustomerDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				return myInfo;
			}
			
		}catch(Exception e) {
			throw e;
		}finally {
			DBUtil.close(con, pstmt);
		}
		return myInfo;
	}
	
}
