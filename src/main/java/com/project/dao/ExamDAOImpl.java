package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ExamVO;

@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insertExam(ExamVO examVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(examVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExamVO> searchExam() {
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamVO where status = true");
			examList = q.list();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return examList;
	}

	@SuppressWarnings("unchecked")
	public List<ExamVO> SearchByID(ExamVO examVO) {
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamVO where status = true and id=" + examVO.getId());
			examList = (List<ExamVO>) q.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return examList;

	}
	public List<ExamVO> searchCorrectOptionandQuestionByStreamId(int id) {
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamVO where status = true and streamTypeVO="+id);
			examList = q.list();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return examList;
	}


}
