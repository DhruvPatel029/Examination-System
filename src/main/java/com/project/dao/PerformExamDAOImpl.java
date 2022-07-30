package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ResultVO;

@Repository
public class PerformExamDAOImpl implements PerformExamDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insertResult(ResultVO resultVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(resultVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
