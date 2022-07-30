package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ExamDAO;
import com.project.model.ExamVO;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamDAO examDAO;

	public void insertExam(ExamVO examVO)

	{
		this.examDAO.insertExam(examVO);
	}

	public List<ExamVO> searchExam() {
		return this.examDAO.searchExam();
	}

	public List<ExamVO> SearchByID(ExamVO examVO) {
		return this.examDAO.SearchByID(examVO);
	}

	public List<ExamVO> searchExambySubject(int streamId) {
		return this.examDAO.searchCorrectOptionandQuestionByStreamId(streamId);
	}

}
