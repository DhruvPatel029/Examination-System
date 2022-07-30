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
@Table(name="Complain")
public class ComplainVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ComplainId")
	private int complainId;
	
	@Column(name="ComplainSubject")
	private String complainSubject;
	
	@Column(name="ComplainDescription")
	private String complainDescription;
	
	@Column(name="ComplainDate")
	private String complainDate;
	
	@Column(name="ComplainStatus")
	private String complainStatus;
	
	@Column(name="Replay")
	private String reply;
	
	@Column(name="ReplayDate")
	private String replyDate;
	
	@Column(name="FileName")
	private String fileName;
	
	@Column(name="FilePath")
	private String filePath;


	@Column(name="Status")
	private boolean status=true;

	@ManyToOne
	@JoinColumn(name="loginId")
	private LoginVO loginVO;
	
	
	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

		public String getComplainSubject() {
		return complainSubject;
	}

	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}
		
		public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

		public String getComplainDescription() {
		return complainDescription;
	}

	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}

	public String getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
