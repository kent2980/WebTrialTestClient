package com.trial.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.trial.sql.DataBaseConnect;
import com.trial.sql.model.QtAnswer;

public class QtAnswerDAO {
	public List<QtAnswer> findAll() {
		
		String sql = "SELECT T1.ID,T1.QT_CODE,T2.QT_NAME,T1.QT_NO,T1.ANSWER1,T1.ANSWER2,T1.ANSWER3,T1.ANSWER4,T1.COLUMNS "
					+ "FROM QT_ANSWER T1,QT_CODE T2 "
					+ "WHERE T1.QT_CODE = T2.CODE";
		
		List<QtAnswer> answerList = new ArrayList<>();
		
		try(Connection con = DataBaseConnect.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				int qtCode = rs.getInt("QT_CODE");
				String qtName = rs.getString("QT_NAME");
				int qtNo = rs.getInt("QT_NO");
				String answer1 = rs.getString("ANSWER1");
				String answer2 = rs.getString("ANSWER2");
				String answer3 = rs.getString("ANSWER3");
				String answer4 = rs.getString("ANSWER4");
				int columns = rs.getInt("COLUMNS");
				answerList.add(new QtAnswer(id,qtCode,qtName,qtNo,answer1,answer2,answer3,answer4,columns));
			}
		}catch(SQLException | NamingException e) {
			e.printStackTrace();
			return null;
		}
		return answerList;
	}
}
