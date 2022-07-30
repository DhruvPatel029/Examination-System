package com.project.dao;

import java.util.List;

import com.project.model.ComplainVO;

public interface ComplainDAO {

	void insertComplain(ComplainVO complainVO);
	
	List<ComplainVO> adminViewComplain();
	
	List searchComplaint(ComplainVO complainVO);
	
	List<ComplainVO> SearchByID(ComplainVO complainVO);

}
