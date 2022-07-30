package com.project.service;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginService  {

	public void insertLogin(LoginVO loginVO);
	
	public List<LoginVO> searchLoginID(String loginService);
	
	List<LoginVO> searchLogin();
	
	List searchLoginByID(int id);
}
