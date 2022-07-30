package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;



@Controller
public class FeedbackController {

	@Autowired
	 private LoginService loginService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping(value="user/loadFeedback")
	public ModelAndView loadFeedback(@ModelAttribute FeedbackVO feedbackVO)
	{
		String userName = Basemethods.getUser();
		List loginList  = loginService.searchLoginID(userName);
		LoginVO loginVO2 = (LoginVO) loginList.get(0);	
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.viewUserFeedback(feedbackVO);
		
		return new ModelAndView("user/addFeedback","FeedbackVO",new FeedbackVO()).addObject("feedbackList", feedbackList);
	}
	@PostMapping(value="/user/insertRaiting")
	public ModelAndView insertFeedback(@ModelAttribute FeedbackVO feedbackVO,LoginVO loginVO)
	{
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);		
		feedbackVO.setLoginVO(loginVO2);
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/user/loadFeedback");
	}
	@GetMapping(value="admin/viewFeedback")
	public ModelAndView viewFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		List feedbackList = this.feedbackService.viewFeedback(feedbackVO);
		
		return new ModelAndView("admin/viewFeedback","feedbackList",feedbackList);
	}
	@GetMapping(value="user/viewUserFeedback")
	public ModelAndView viewstaffFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		String userName = Basemethods.getUser();
		List loginList  = loginService.searchLoginID(userName);
		LoginVO loginVO2 = (LoginVO) loginList.get(0);	
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.viewUserFeedback(feedbackVO);
		
		return new ModelAndView("redirect:/user/loadFeedback").addObject("feedbackList", feedbackList);
		
	}

}
