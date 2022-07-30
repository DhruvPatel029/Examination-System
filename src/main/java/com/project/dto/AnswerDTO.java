package com.project.dto;

import com.project.model.LoginVO;
import com.project.model.StreamTypeVO;

public class AnswerDTO {

	private int id;

	private int questionId;

	private String optionSelected;

	private LoginVO loginVO;

	private StreamTypeVO streamTypeVO;

	public StreamTypeVO getStreamTypeVO() {
		return streamTypeVO;
	}

	public void setStreamTypeVO(StreamTypeVO streamTypeVO) {
		this.streamTypeVO = streamTypeVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}
