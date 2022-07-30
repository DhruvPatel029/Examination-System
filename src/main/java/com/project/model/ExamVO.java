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
@Table(name = "exam_tbl")
public class ExamVO {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "question")
	private String examQuestion;

	@Column(name = "option1")
	private String option1;

	@Column(name = "option2")
	private String option2;

	@Column(name = "option3")
	private String option3;

	@Column(name = "option4")
	private String option4;

	@Column(name = "correctOption")
	private String correctOption;

	@ManyToOne
	@JoinColumn(name = "streamTypeId")
	private StreamTypeVO streamTypeVO;

	@ManyToOne
	@JoinColumn(name = "examTypeId")
	private ExamTypeVO examTypeVO;

	@Column(name = "status")
	private boolean status = true;

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamQuestion() {
		return examQuestion;
	}

	public void setExamQuestion(String examQuestion) {
		this.examQuestion = examQuestion;
	}

	public StreamTypeVO getStreamTypeVO() {
		return streamTypeVO;
	}

	public void setStreamTypeVO(StreamTypeVO streamTypeVO) {
		this.streamTypeVO = streamTypeVO;
	}

	public ExamTypeVO getExamTypeVO() {
		return examTypeVO;
	}

	public void setExamTypeVO(ExamTypeVO examTypeVO) {
		this.examTypeVO = examTypeVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
