package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ExamTypeDAO;
import com.project.model.ExamTypeVO;

@Service
@Transactional
public class ExamTypeServiceImpl implements ExamTypeService{

	@Autowired
	ExamTypeDAO examTypeDAO;
	
	public void insertExamType(ExamTypeVO examTypeVO)
	{
		this.examTypeDAO.insertExamType(examTypeVO);
	}
	public List<ExamTypeVO> searchExamType()
	{
		return this.examTypeDAO.searchExamType();
	}
	public List<ExamTypeVO> searchByID(ExamTypeVO examTypeVO)
	{
		return this.examTypeDAO.searchByID(examTypeVO);
	}

}
