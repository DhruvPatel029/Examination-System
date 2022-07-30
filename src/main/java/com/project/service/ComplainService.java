package com.project.service;

import java.util.List;

import com.project.model.ComplainVO;

public interface ComplainService {

	void insertComplain(ComplainVO complainVO);
	
	List<ComplainVO> adminViewComplain();
	
	public List searchComplaint(ComplainVO complainVO);

	List<ComplainVO> SearchByID(ComplainVO complainVO);

}
