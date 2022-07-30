package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result_table")
public class ResultVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int resultId;

	@Column
	private int marksObtained;

	@Column
	private int totalMarks;

	@ManyToOne
	@JoinColumn
	private LoginVO loginVO;

	@ManyToOne
	@JoinColumn
	private StreamTypeVO streamTypeVO;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public StreamTypeVO getStreamTypeVO() {
		return streamTypeVO;
	}

	public void setStreamTypeVO(StreamTypeVO streamTypeVO) {
		this.streamTypeVO = streamTypeVO;
	}

}
