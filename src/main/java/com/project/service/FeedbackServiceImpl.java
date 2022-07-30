package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FeedbackDAO;
import com.project.model.FeedbackVO;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackDAO feedbackDAO;

	@Transactional
	public void insertFeedback(FeedbackVO feedbackVO) {
		
		this.feedbackDAO.insertFeedback(feedbackVO);
	}
	
	@Transactional
	public List viewFeedback(FeedbackVO feedbackVO) {
		
		List feedbackList = this.feedbackDAO.viewFeedback(feedbackVO);
		return feedbackList;
	}
	
	@Transactional
    public List viewUserFeedback(FeedbackVO feedbackVO) {
    	
        List complainList =	this.feedbackDAO.viewUserFeedback(feedbackVO);
        return complainList;
    
    }

}
