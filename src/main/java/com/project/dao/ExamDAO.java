package com.project.dao;

import java.util.List;

import com.project.model.ExamVO;

public interface ExamDAO {

	public void insertExam(ExamVO examVO);

	List<ExamVO> searchExam();

	List<ExamVO> SearchByID(ExamVO examVO);

	List<ExamVO> searchCorrectOptionandQuestionByStreamId(int streamId);

}
