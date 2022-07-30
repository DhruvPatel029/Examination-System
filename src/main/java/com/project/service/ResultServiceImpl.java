package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ResultDAO;
import com.project.model.ResultVO;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDao;

	@Override
	public List<ResultVO> searchResultByUsername(String username) {
		return this.resultDao.searchResultByUsername(username);
	}

	@Override
	public List<ResultVO> searchResults() {
		return this.resultDao.searchResults();
	}
}
