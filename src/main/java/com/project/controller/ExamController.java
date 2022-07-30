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
import com.project.model.ExamVO;
import com.project.model.StreamTypeVO;
import com.project.service.ExamService;
import com.project.service.ExamTypeService;
import com.project.service.StreamTypeService;

@Controller
public class ExamController {

	@Autowired
	ExamTypeService examTypeservice;

	@Autowired
	StreamTypeService streamTypeSerivce;

	@Autowired
	ExamService examService;

	@GetMapping(value = "admin/loadExam")
	public ModelAndView loadExam() {
		List<ExamTypeVO> examTypeList = this.examTypeservice.searchExamType();
		List<StreamTypeVO> streamTypeList = this.streamTypeSerivce.searchStreamType();

		return new ModelAndView("admin/addExam", "ExamVO", new ExamVO()).addObject("examTypeList", examTypeList)
				.addObject("streamTypeList", streamTypeList);
	}

	@PostMapping(value = "admin/insertExam")
	public ModelAndView insertExam(@ModelAttribute ExamVO examVO, @RequestParam int id) {
		examVO.setId(id);
		this.examService.insertExam(examVO);
		return new ModelAndView("redirect:/admin/loadExam");
	}

	@GetMapping(value = "admin/searchExam")
	public ModelAndView searchLoanType() {
		List<ExamVO> examList = this.examService.searchExam();
		return new ModelAndView("admin/viewExam", "examList", examList);
	}

	@GetMapping(value = "admin/deleteExam")
	public ModelAndView deleteLoanType(@ModelAttribute ExamVO examVO, @RequestParam int id) {
		examVO.setId(id);
		List<ExamVO> examList = examService.SearchByID(examVO);
		ExamVO examVO2 = (ExamVO) examList.get(0);
		examVO2.setStatus(false);
		examService.insertExam(examVO2);
		return new ModelAndView("redirect:/admin/searchExam");
	}

	@GetMapping(value = "admin/editExam")
	public ModelAndView editLoanType(@ModelAttribute ExamTypeVO examTypeVO, @ModelAttribute ExamVO examVO,
			@RequestParam int id) {
		List<ExamTypeVO> examTypeList = this.examTypeservice.searchExamType();
		List<StreamTypeVO> streamTypeList = this.streamTypeSerivce.searchStreamType();
		examVO.setId(id);
		List<ExamVO> examList = examService.SearchByID(examVO);
		return new ModelAndView("admin/addExam", "ExamVO", (ExamVO) examList.get(0))
				.addObject("examTypeList", examTypeList).addObject("streamTypeList", streamTypeList);
	}

}
