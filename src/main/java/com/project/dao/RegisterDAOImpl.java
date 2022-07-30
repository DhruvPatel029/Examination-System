package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertRegister(RegisterVO registerVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(registerVO);
	}
	public List searchUsers(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegisterVO");
		List ls = q.list();
		return ls;
		
	}

}
