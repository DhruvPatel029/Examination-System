package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ExamTypeVO;

@Repository
public class ExamTypeDAOImpl implements ExamTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertExamType(ExamTypeVO examTypeVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(examTypeVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExamTypeVO> searchExamType() {
		List<ExamTypeVO> examList = new ArrayList<ExamTypeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamTypeVO where status = true");
			examList = q.list();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return examList;
	}

	@SuppressWarnings("unchecked")
	public List<ExamTypeVO> searchByID(ExamTypeVO examTypeVO) {
		List<ExamTypeVO> examList = new ArrayList<ExamTypeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamTypeVO where status = true and id=" + examTypeVO.getId());
			examList = (List<ExamTypeVO>) q.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return examList;

	}

}
