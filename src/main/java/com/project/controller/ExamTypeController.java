package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ExamTypeVO;
import com.project.service.ExamTypeService;

@Controller
public class ExamTypeController {

	@Autowired
	ExamTypeService examTypeService;

	@GetMapping(value = "admin/loadexamType")
	public ModelAndView loadExamType() {
		return new ModelAndView("admin/addExamType", "ExamTypeVO", new ExamTypeVO());

	}

	@PostMapping(value = "admin/insertExamType")
	public ModelAndView insertLoanType(@ModelAttribute ExamTypeVO examTypeVO, @RequestParam int id) {
		examTypeVO.setId(id);
		this.examTypeService.insertExamType(examTypeVO);
		return new ModelAndView("redirect:/admin/loadexamType");

	}

	@GetMapping(value = "admin/searchexamType")
	public ModelAndView searchExamType() {
		List<ExamTypeVO> examList = this.examTypeService.searchExamType();
		return new ModelAndView("admin/viewExamType", "examList", examList);
	}

	@GetMapping(value = "admin/deleteExamType")
	public ModelAndView deleteExamType(@ModelAttribute ExamTypeVO examTypeVO, @RequestParam int id) {
		examTypeVO.setId(id);
		List<ExamTypeVO> examList = examTypeService.searchByID(examTypeVO);
		ExamTypeVO examTypeVO2 = (ExamTypeVO) examList.get(0);
		examTypeVO2.setStatus(false);
		examTypeService.insertExamType(examTypeVO2);
		return new ModelAndView("redirect:/admin/searchexamType");
	}

	@GetMapping(value = "admin/editExamType")
	public ModelAndView editLoanType(@ModelAttribute ExamTypeVO examTypeVO, @RequestParam int id) {
		examTypeVO.setId(id);
		List<ExamTypeVO> examList = examTypeService.searchByID(examTypeVO);
		return new ModelAndView("admin/addExamType", "ExamTypeVO", (ExamTypeVO) examList.get(0));
	}

}
