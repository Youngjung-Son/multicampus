package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Coach_PlayerDTO;
import model.domain.PlayerDTO;
import model.domain.ScheduleDTO;
import util.DBUtil;

public class LeagueDAO {

    /*
       * 멀티캠퍼스 선수 전체 출력 select * from player where tname = '멀티캠퍼스';
       */
      public static ArrayList<PlayerDTO> getOne(String tname) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         ArrayList<PlayerDTO> data = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select * from player where tname = ?");
            pstmt.setString(1, tname);
            rs = pstmt.executeQuery();
            data = new ArrayList<PlayerDTO>();
            while (rs.next()) {
               data.add(new PlayerDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getLong(6)));
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; // catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt, rs);
         }
         return data;
      }

      /*
       * 선수 이름 입력받아서 선수 전체 정보 출력 select * from player where name = '?';
       */
      public static ArrayList<PlayerDTO> getDetail(String name) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         ArrayList<PlayerDTO> data = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select * from player where name = ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            data = new ArrayList<PlayerDTO>();
            while (rs.next()) {

               data.add(new PlayerDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; // catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt, rs);
         }
         return data;
      }
      
      ////////////////// 관리자 모드에서 실행///////////////////
      /*
       * 멀티캠퍼스 선수 목록 삽입 "insert into player values(?,?,?,?,?)"
       */
      public static boolean insert(PlayerDTO newPlayer) throws Exception{
         Connection con = null;
         PreparedStatement pstmt =null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("insert into player values(?,?,?,?,?,?)");
            pstmt.setString(1, newPlayer.getTname());
            pstmt.setString(2, newPlayer.getName());
            pstmt.setInt(3, newPlayer.getBnumber());
            pstmt.setString(4, newPlayer.getPosition());
            pstmt.setInt(5, newPlayer.getStat());
            pstmt.setLong(6, newPlayer.getInumber());
            
            int result = pstmt.executeUpdate();
            if(result==0) {
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
      
      /*
       * 멀티캠퍼스 선수 목록 수정 "Update player set stat = ? where inumber = ?"
       */
      public static boolean update(int stat, long inumber) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt =null;
         String sql = "update player set stat = ? where inumber = ?";
         try {
            con = DBUtil.getConnection();
            // 고정된 문장으로 sql 실행 객체 생성
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, stat);
            pstmt.setLong(2, inumber);

            int result = pstmt.executeUpdate();
            if(result==0) {
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

      
      /*
       * 멀티캠퍼스 선수 목록 삭제 "delete from player where inumber = ?"
       */
      public static boolean delete(long inumber) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;
         
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("delete from player where inumber=?");
            pstmt.setLong(1, inumber);
            // db에 실제 실행
            int result = pstmt.executeUpdate();//insert / update / delete 실행 메소드
            if(result==0) {
               return false;
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; //catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt);
         }
         return true;
      }
      ///////////////////////////////////////////////////

      /*
       * 경기 일정 출력
       */
      public static ArrayList<ScheduleDTO> getSchedule() throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         ArrayList<ScheduleDTO> data = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select * from schedule");
            rs = pstmt.executeQuery();
            data = new ArrayList<ScheduleDTO>();
            while (rs.next()) {
               data.add(new ScheduleDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; // catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt, rs);
         }
         return data;
      }

         
      /*
       * 다음 경기 일정 출력 - sysdate + 경기 날짜 rownum
       */
      public static ArrayList<ScheduleDTO> getNextResult(int sdate) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;   
         ResultSet rs = null;
         ArrayList<ScheduleDTO> data = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select competition, sdate, stime, swhere, awayteam from schedule where sdate >= ? and rownum <=1 order by sdate asc");
            pstmt.setInt(1, sdate);
            rs = pstmt.executeQuery();
            data = new ArrayList<ScheduleDTO>();
            while (rs.next()) {
               data.add(new ScheduleDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                     
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; // catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt, rs);
         }
         return data;
      }
      
      
      
      /*
       * 이번 시즌 awayteam과의 경기 결과 출력
       */
      public static ArrayList<ScheduleDTO> getMResult(String awayteam) throws SQLException {
         Connection con = null;
         PreparedStatement pstmt = null;   
         ResultSet rs = null;
         ArrayList<ScheduleDTO> data = null;
         try {
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement("select * from schedule where awayteam = ? ");
            pstmt.setString(1, awayteam);
            rs = pstmt.executeQuery();
            data = new ArrayList<ScheduleDTO>();
            while (rs.next()) {
               data.add(new ScheduleDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e; // catch내에서 throw 해야만 end user에게 상황 전달 가능
         } finally {
            DBUtil.close(con, pstmt, rs);
         }
         return data;
      }

   /*
    * 경기 결과 분석 출력 1.사용자로부터 경기일을 입력 받음 2. 필요 정보 
    * 1. 장소 
    * 2. away team 
    * 3. home, away 경기
    * 기록이 있는지? 있다면 반영
    *   
    * 4. 경기 일정 테이블과 감독 테이블 조인 - home away 둘다 필요 
    * 5. 경기 일정 테이블과 선수
    * 테이블 조인 - fw, mf, df 선수들의 스탯 비교 후 반환
    */

   public static ArrayList<ScheduleDTO> getSchedule(int date) throws Exception {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<ScheduleDTO> datas = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("select * from Schedule where sdate = ?");
         pstmt.setInt(1, date);
         rs = pstmt.executeQuery();

         datas = new ArrayList<ScheduleDTO>();
         if (rs.next()) {
            datas.add(new ScheduleDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                  rs.getString(5), rs.getInt(6), rs.getInt(7)));
         }
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      } finally {
         DBUtil.close(con, pstmt, rs);
      }
      return datas;
   }
   
   public static ArrayList<Coach_PlayerDTO> getTeam(int date) throws Exception {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<Coach_PlayerDTO> datas = null;
      try {
         con = DBUtil.getConnection();
         pstmt = con.prepareStatement("select * from Schedule where sdate = ?");
         pstmt.setInt(1, date);
         rs = pstmt.executeQuery();

         datas = new ArrayList<Coach_PlayerDTO>();
         if (rs.next()) {
            datas.add(new Coach_PlayerDTO(rs.getString(1), rs.getInt(2), rs.getInt(3)));
         }
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      } finally {
         DBUtil.close(con, pstmt, rs);
      }
      return datas;
   }
   
}