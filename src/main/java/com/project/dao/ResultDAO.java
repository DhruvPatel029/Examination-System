package com.project.dao;

import java.util.List;

import com.project.model.ResultVO;

public interface ResultDAO {

	List<ResultVO> searchResultByUsername(String username);
	
	List<ResultVO> searchResults();
}
