package com.project.service;

import java.util.List;

import com.project.model.ExamTypeVO;


public interface ExamTypeService {

	void insertExamType(ExamTypeVO examTypeVO);
	
	List<ExamTypeVO> searchExamType();
	
	List<ExamTypeVO> searchByID(ExamTypeVO examTypeVO);

}
