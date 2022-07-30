package com.project.dao;


import java.util.List;

import com.project.model.RegisterVO;

public interface RegisterDAO  
{
	void insertRegister(RegisterVO registerVO);

	List searchUsers();
}
