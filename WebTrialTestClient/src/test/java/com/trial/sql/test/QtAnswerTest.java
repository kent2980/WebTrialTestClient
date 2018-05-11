package com.trial.sql.test;

import java.util.List;

import com.trial.sql.dao.QtAnswerDAO;
import com.trial.sql.model.QtAnswer;

public class QtAnswerTest {
	static public void main(String[] args) {
		
		//レコード検索
		QtAnswerDAO qtDAO = new QtAnswerDAO();
		List<QtAnswer> qtList = qtDAO.findAll();

		qtList.stream()
			  .filter(s -> s.getQtCode() == 11)
			  .forEach(System.out::println);
	}
}
