package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.StreamTypeDAO;
import com.project.model.StreamTypeVO;

@Service
@Transactional
public class StreamTypeServiceImpl implements StreamTypeService {

	@Autowired
	StreamTypeDAO streamTypeDAO;

	public void insertStreamType(StreamTypeVO streamTypeVO) {
		this.streamTypeDAO.insertStreamType(streamTypeVO);
	}

	public List<StreamTypeVO> searchStreamType() {
		return this.streamTypeDAO.searchStreamType();
	}

	public List<StreamTypeVO> searchByID(StreamTypeVO streamTypeVO) {
		return this.streamTypeDAO.SearchByID(streamTypeVO);
	}

	public List<StreamTypeVO> searchByID1(int id) {
		return this.streamTypeDAO.SearchByID1(id);
	}

	
}
