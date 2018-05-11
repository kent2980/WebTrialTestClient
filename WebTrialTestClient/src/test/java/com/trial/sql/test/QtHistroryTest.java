package com.trial.sql.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.trial.sql.dao.QtHistoryDAO;
import com.trial.sql.model.QtHistory;

public class QtHistroryTest {

	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		List<QtHistory> historyList = new ArrayList<>();
		historyList.add(new QtHistory(dateTime,3,6,"A","D","D","D"));
		historyList.add(new QtHistory(dateTime,3,11,"A",null,null,null));
		historyList.add(new QtHistory(dateTime,3,12,"B","C","D",null));
		historyList.add(new QtHistory(dateTime,3,23,"D","F",null,null));
		QtHistoryDAO.insertHistory(historyList);
		QtHistoryDAO.insertHistory(new QtHistory(dateTime,5,15,"B",null,null,null));
		List<QtHistory> historyTest = new QtHistoryDAO().findAll();
		historyTest.stream().forEach(System.out::println);
		System.out.println("登録件数"  + historyTest.size() + "件");
	}

}
