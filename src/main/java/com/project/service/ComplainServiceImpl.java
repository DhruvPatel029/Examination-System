package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ComplainDAO;
import com.project.model.ComplainVO;

@Service
@Transactional
public class ComplainServiceImpl implements ComplainService{

	@Autowired
	ComplainDAO complainDAO;
	
	public void insertComplain(ComplainVO complainVO)
	{
		this.complainDAO.insertComplain(complainVO);
	}
	
	public List<ComplainVO> adminViewComplain()
	{
		return this.complainDAO.adminViewComplain();
	}
	public List searchComplaint(ComplainVO complainVO) {
		
		List complaintList = this.complainDAO.searchComplaint(complainVO);
		
		return complaintList;	
	}
	
	public List<ComplainVO> SearchByID(ComplainVO complainVO)
	{
		return this.complainDAO.SearchByID(complainVO);
	}

}
