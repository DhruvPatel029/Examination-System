package com.project.service;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackService {

	
	void insertFeedback(FeedbackVO feedbackVO);
	
	List viewFeedback(FeedbackVO feedbackVO);
	
	List viewUserFeedback(FeedbackVO feedbackVO);
}
