package com.project.dao;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackDAO {

	void insertFeedback(FeedbackVO feedbackVO);

	List viewFeedback(FeedbackVO feedbackVO);

	List viewUserFeedback(FeedbackVO feedbackVO);

}
