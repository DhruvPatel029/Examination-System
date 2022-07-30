package com.project.dao;

import java.util.List;

import com.project.model.StreamTypeVO;

public interface StreamTypeDAO {

	public void insertStreamType(StreamTypeVO streamTypeVO);
	
	List<StreamTypeVO> searchStreamType();
	
	List<StreamTypeVO> SearchByID(StreamTypeVO streamTypeVO);

	List<StreamTypeVO> SearchByID1(int id);

}
