package com.project.service;

import java.util.List;

import com.project.model.ExamVO;

public interface ExamService {

	void insertExam(ExamVO examVO);

	List<ExamVO> searchExam();

	List<ExamVO> SearchByID(ExamVO examVO);

	List<ExamVO> searchExambySubject(int id);

}
