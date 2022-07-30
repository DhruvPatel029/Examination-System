package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;

@Repository
public class ComplainDAOImpl implements ComplainDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void insertComplain(ComplainVO complainVO)
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(complainVO);
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<ComplainVO> adminViewComplain()
	{
		List<ComplainVO> complainList = new ArrayList<ComplainVO>();
		try{
	 		Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainVO");
			complainList = q.list();

			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
			return complainList;		
	}
	public List searchComplaint(ComplainVO complainVO) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from ComplainVO where loginVO.id= "+complainVO.getLoginVO().getId());
		List complaintList = q.list();
		return complaintList;
	}
	
	@SuppressWarnings("unchecked")
	public List<ComplainVO> SearchByID(ComplainVO complainVO)
	{
		List<ComplainVO> complainList = new ArrayList<ComplainVO>();
		try{
 		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ComplainVO where status = true and id="+complainVO.getComplainId());
		complainList = (List<ComplainVO>) q.list();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return complainList;

		
	}

}

