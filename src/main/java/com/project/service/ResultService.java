package com.project.service;

import java.util.List;

import com.project.model.ResultVO;

public interface ResultService {

	List<ResultVO> searchResultByUsername(String username);

	List<ResultVO> searchResults();
}
