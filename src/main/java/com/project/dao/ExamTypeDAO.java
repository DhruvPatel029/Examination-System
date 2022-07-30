package com.project.dao;

import java.util.List;

import com.project.model.ExamTypeVO;

public interface ExamTypeDAO {

	 void insertExamType(ExamTypeVO examTypeVO);
	 
	 List<ExamTypeVO> searchExamType();
	 
	 List<ExamTypeVO> searchByID(ExamTypeVO examTypeVO);

}
