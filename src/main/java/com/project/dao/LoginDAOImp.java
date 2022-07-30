package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;

@Repository
public class LoginDAOImp implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertLogin(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginVO);
	}

	public List searchLoginID(String loginService) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '" + loginService + "' ");
		List ls = q.list();
		return ls;
	}

	public List searchLogin() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO");
		List ls = q.list();
		return ls;
	}

	public List searchLoginByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where id =" + id);
		List ls = q.list();
		return ls;
	}

}