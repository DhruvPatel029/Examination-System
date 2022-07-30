package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ResultVO;
import com.project.service.ResultService;
import com.project.utils.Basemethods;

@Controller
public class ResultController {

	@Autowired
	private ResultService resultService;

	@GetMapping(value = "user/getResult")
	public ModelAndView getResult() {

		List<ResultVO> resultList = this.resultService.searchResultByUsername(Basemethods.getUser());
		System.out.println(resultList);
		return new ModelAndView("user/viewResult", "resultList", resultList);
	}

	@GetMapping(value = "admin/getResults")
	public ModelAndView seeAdminResults() {

		List<ResultVO> resultList = this.resultService.searchResults();
		System.out.println(resultList);
		return new ModelAndView("admin/viewResult", "resultList", resultList);
	}

}
