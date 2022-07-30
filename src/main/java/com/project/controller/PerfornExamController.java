package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.ExamDTO;
import com.project.model.ExamVO;
import com.project.model.StreamTypeVO;
import com.project.service.ExamService;
import com.project.service.PerformExamService;
import com.project.service.StreamTypeService;

@Controller
public class PerfornExamController {

	@Autowired
	ExamService examService;

	@Autowired
	PerformExamService performExamService;

	@Autowired
	StreamTypeService streamTypeService;

	@GetMapping(value = "user/selectStream")
	public ModelAndView loadexam() {

		List<StreamTypeVO> streamTypeList = this.streamTypeService.searchStreamType();
		return new ModelAndView("user/selectStream", "streamTypeList", streamTypeList);
	}

	/*
	 * @GetMapping(value = "user/getexambyStream") public ResponseEntity
	 * getgetexambyStream(@RequestParam int id) {
	 * System.out.println("In method::::::::::::::::::::::::::::::::::::::");
	 * System.out.println("id::::::::::::::::::::::::::::::::::::::::::::::::"+
	 * id); List examList = this.examService.searchExambySubject(id);
	 * System.out.println(examList.size()); return new
	 * ResponseEntity(examList.get(0), HttpStatus.OK); }
	 */

	@PostMapping(value = "user/loadExam")
	public ModelAndView performexam(@RequestParam("streamType") int streamid) {

		List<ExamVO> questionList = this.examService.searchExambySubject(streamid);

		return new ModelAndView("user/performExam", "questionList", questionList).addObject("streamId", streamid);
	}

	@PostMapping(value = "user/submitExam")
	public ResponseEntity<Integer> submitExam(@RequestBody List<ExamDTO> answers) {
		int obtainedMarks = this.performExamService.verifyAndInsertResult(answers);
		return new ResponseEntity<Integer>(obtainedMarks, HttpStatus.OK);
	}
}
