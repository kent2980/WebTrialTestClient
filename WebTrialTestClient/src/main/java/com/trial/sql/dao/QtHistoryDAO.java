package com.trial.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.trial.sql.DataBaseConnect;
import com.trial.sql.model.QtHistory;

public class QtHistoryDAO {
	private final static String allSQL = "SELECT FROM_TIME,QT_CODE,QT_NO,ANSWER1,ANSWER2,ANSWER3,ANSWER4 "
										+ "FROM QT_HISTORY ";
	
	private final static String selectSQL = "SELECT FROM_TIME,QT_CODE,QT_NO,ANSWER1,ANSWER2,ANSWER3,ANSWER4 "
											+ "FROM QT_HISTORY "
											+ "WHERE QT_CODE = ? AND QT_NO = ?";
	
	private final static String insertSQL = "INSERT INTO QT_HISTORY (FROM_TIME,QT_CODE,QT_NO,ANSWER1,ANSWER2,ANSWER3,ANSWER4) "
											+ "VALUES (?,?,?,?,?,?,?)";
	
	public List<QtHistory> findAll(){
		List<QtHistory> historyList = new ArrayList<>();
		
		try(Connection con = DataBaseConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(allSQL)){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Timestamp timeStamp = rs.getTimestamp("FROM_TIME");
				int qtCodes = rs.getInt("QT_CODE");
				int qtNos = rs.getInt("QT_NO");
				String answer1 = rs.getString("ANSWER1");
				String answer2 = rs.getString("ANSWER2");
				String answer3 = rs.getString("ANSWER3");
				String answer4 = rs.getString("ANSWER4");
				
				LocalDateTime dateTime = timeStamp.toLocalDateTime();
				
				QtHistory history = new QtHistory(dateTime, qtCodes, qtNos, answer1, answer2, answer3, answer4);
				
				historyList.add(history);
				
			}
			
		}catch(SQLException | NamingException e) {
			e.printStackTrace();
			return null;
		}
		return historyList;
	}
	
	public List<QtHistory> findSelect(int qtCode,int qtNo) {
		List<QtHistory> historyList = new ArrayList<>();
		
		try(Connection con = DataBaseConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(selectSQL)){
			
			pstmt.setInt(1, qtCode);
			pstmt.setInt(2, qtNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Timestamp timeStamp = rs.getTimestamp("FROM_TIME");
				int qtCodes = rs.getInt("QT_CODE");
				int qtNos = rs.getInt("QT_NO");
				String answer1 = rs.getString("ANSWER1");
				String answer2 = rs.getString("ANSWER2");
				String answer3 = rs.getString("ANSWER3");
				String answer4 = rs.getString("ANSWER4");
				
				LocalDateTime dateTime = timeStamp.toLocalDateTime();
				
				QtHistory history = new QtHistory(dateTime, qtCodes, qtNos, answer1, answer2, answer3, answer4);
				
				historyList.add(history);
			}
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			return null;
		}
		return historyList;
	}
	
	public static void insertHistory(QtHistory history) {
		try(Connection con = DataBaseConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertSQL)){
			
			String timeStamp = history.getTimeStamp();
			int qtCode = history.getQtCode();
			int qtNo = history.getQtNo();
			String answer1 = history.getAnswer1();
			String answer2 = history.getAnswer2();
			String answer3 = history.getAnswer3();
			String answer4 = history.getAnswer4();
			
			pstmt.setString(1, timeStamp);
			pstmt.setInt(2, qtCode);
			pstmt.setInt(3, qtNo);
			pstmt.setString(4, answer1);
			pstmt.setString(5, answer2);
			pstmt.setString(6, answer3);
			pstmt.setString(7, answer4);

			pstmt.executeUpdate();			
            System.out.println(pstmt.toString());            
			System.out.println("登録成功");
			
		}catch(SQLException | NamingException e) {
			System.out.println("登録失敗");
			e.printStackTrace();
		}
	}
	
	public static void insertHistory(List<QtHistory> historyList) {
		try(Connection con = DataBaseConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertSQL)){
				
				con.setAutoCommit(false);
				
				for(QtHistory history : historyList) {
					
					String timeStamp = history.getTimeStamp();
					int qtCode = history.getQtCode();
					int qtNo = history.getQtNo();
					String answer1 = history.getAnswer1();
					String answer2 = history.getAnswer2();
					String answer3 = history.getAnswer3();
					String answer4 = history.getAnswer4();
					
					pstmt.setString(1, timeStamp);
					pstmt.setInt(2, qtCode);
					pstmt.setInt(3, qtNo);
					pstmt.setString(4, answer1);
					pstmt.setString(5, answer2);
					pstmt.setString(6, answer3);
					pstmt.setString(7, answer4);
					
					pstmt.executeUpdate();
					pstmt.addBatch();
					
	                System.out.println(pstmt.toString());
				}
				try {
					con.commit();
					System.out.println("登録成功");
				}catch(SQLException e) {
					con.rollback();
					System.out.println("登録失敗");
					e.printStackTrace();
				}
				
			}catch(SQLException | NamingException e) {
				e.printStackTrace();
			}
	}
}
