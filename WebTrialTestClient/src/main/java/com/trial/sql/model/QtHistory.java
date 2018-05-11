package com.trial.sql.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QtHistory {
	private String timeStamp;
	private int qtCode;
	private int qtNo;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public QtHistory(LocalDateTime timeStamp, int qtCode, int qtNo,String answer1, String answer2, String answer3, String answer4) {
		super();		
		this.timeStamp = formatter.format(timeStamp);
		this.qtCode = qtCode;
		this.qtNo = qtNo;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public int getQtCode() {
		return qtCode;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public int getQtNo() {
		return qtNo;
	}

	@Override
	public String toString() {
		return "QtHistory [timeStamp=" + timeStamp + ", qtCode=" + qtCode + ", qtNo=" + qtNo + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
	}

}
