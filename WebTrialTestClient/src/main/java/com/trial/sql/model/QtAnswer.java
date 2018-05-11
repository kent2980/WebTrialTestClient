package com.trial.sql.model;

import java.io.Serializable;

public class QtAnswer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int qtCode;
	private String qtName;
	private int qtNo;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	
	public QtAnswer() {}

	public QtAnswer(int id, int qtCode, String qtName, int qtNo, String answer1, String answer2, String answer3, String answer4) {
		super();
		this.id = id;
		this.qtCode = qtCode;
		this.qtName = qtName;
		this.qtNo = qtNo;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}

	public int getId() {
		return id;
	}

	public String getQtName() {
		return qtName;
	}

	public int getQtNo() {
		return qtNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getQtCode() {
		return qtCode;
	}

	@Override
	public String toString() {
		return "QtAnswer [id=" + id + ", qtCode=" + qtCode + ", qtName=" + qtName + ", qtNo=" + qtNo + ", answer1="
				+ answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer1 == null) ? 0 : answer1.hashCode());
		result = prime * result + ((answer2 == null) ? 0 : answer2.hashCode());
		result = prime * result + ((answer3 == null) ? 0 : answer3.hashCode());
		result = prime * result + ((answer4 == null) ? 0 : answer4.hashCode());
		result = prime * result + id;
		result = prime * result + qtCode;
		result = prime * result + ((qtName == null) ? 0 : qtName.hashCode());
		result = prime * result + qtNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QtAnswer other = (QtAnswer) obj;
		if (answer1 == null) {
			if (other.answer1 != null)
				return false;
		} else if (!answer1.equals(other.answer1))
			return false;
		if (answer2 == null) {
			if (other.answer2 != null)
				return false;
		} else if (!answer2.equals(other.answer2))
			return false;
		if (answer3 == null) {
			if (other.answer3 != null)
				return false;
		} else if (!answer3.equals(other.answer3))
			return false;
		if (answer4 == null) {
			if (other.answer4 != null)
				return false;
		} else if (!answer4.equals(other.answer4))
			return false;
		if (id != other.id)
			return false;
		if (qtCode != other.qtCode)
			return false;
		if (qtName == null) {
			if (other.qtName != null)
				return false;
		} else if (!qtName.equals(other.qtName))
			return false;
		if (qtNo != other.qtNo)
			return false;
		return true;
	}	
	
}