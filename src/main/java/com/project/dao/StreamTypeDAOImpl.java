package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.StreamTypeVO;

@Repository
public class StreamTypeDAOImpl implements StreamTypeDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insertStreamType(StreamTypeVO streamTypeVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(streamTypeVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<StreamTypeVO> searchStreamType() {
		List<StreamTypeVO> streamTypeList = new ArrayList<StreamTypeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StreamTypeVO where status = true");
			streamTypeList = q.list();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return streamTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<StreamTypeVO> SearchByID(StreamTypeVO streamTypeVO) {
		List<StreamTypeVO> streamTypeList = new ArrayList<StreamTypeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StreamTypeVO where status = true and id=" + streamTypeVO.getId());
			streamTypeList = (List<StreamTypeVO>) q.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return streamTypeList;

	}
	
	public List<StreamTypeVO> SearchByID1(int id) {
		List<StreamTypeVO> streamTypeList = new ArrayList<StreamTypeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StreamTypeVO where status = true and id=" + id);
			streamTypeList = (List<StreamTypeVO>) q.list();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return streamTypeList;

	}

}
