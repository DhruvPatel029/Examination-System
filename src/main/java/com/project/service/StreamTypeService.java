package com.project.service;

import java.util.List;

import com.project.model.StreamTypeVO;

public interface StreamTypeService {

	void insertStreamType(StreamTypeVO streamTypeVO);
	
	List<StreamTypeVO> searchStreamType();
	
	List<StreamTypeVO> searchByID(StreamTypeVO streamTypeVO);
	
	List<StreamTypeVO> searchByID1(int id);

}
