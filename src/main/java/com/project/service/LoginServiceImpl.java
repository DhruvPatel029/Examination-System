package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDAO;
import com.project.model.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Transactional
	public void insertLogin(LoginVO loginVO) {
		loginDAO.insertLogin(loginVO);
	}

	@Transactional
	public List<LoginVO> searchLoginID(String loginService) {
		@SuppressWarnings("unchecked")
		List<LoginVO> ls = loginDAO.searchLoginID(loginService);
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<LoginVO> searchLogin() {
		return this.loginDAO.searchLogin();
	}

	
	@Override
	@Transactional
	public List searchLoginByID(int id) {
		return this.loginDAO.searchLoginByID(id);
	}
}
