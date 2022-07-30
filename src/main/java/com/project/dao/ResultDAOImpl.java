package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ResultVO;

@Repository
public class ResultDAOImpl implements ResultDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<ResultVO> searchResultByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ResultVO where loginVO.username = '" + username + "' ");
		List<ResultVO> ls = q.list();
		return ls;
	}

	public List<ResultVO> searchResults() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ResultVO");
		List<ResultVO> ls = q.list();
		return ls;
	}
}
