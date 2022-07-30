package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.model.StreamTypeVO;
import com.project.service.StreamTypeService;

@Controller
public class StreamTypeController {

	@Autowired
	StreamTypeService streamTypeService;

	@GetMapping(value = "admin/loadStreamType")
	public ModelAndView loadStreamType() {
		return new ModelAndView("admin/addStreamType", "StreamTypeVO", new StreamTypeVO());

	}

	@PostMapping(value = "admin/insertStreamType")
	public ModelAndView insertStreamType(@ModelAttribute StreamTypeVO streamTypeVO, @RequestParam int id) {
		streamTypeVO.setId(id);
		this.streamTypeService.insertStreamType(streamTypeVO);
		return new ModelAndView("redirect:/admin/loadStreamType");

	}

	@GetMapping(value = "admin/searchStreamType")
	public ModelAndView searchStreamType() {
		List<StreamTypeVO> streamTypeList = this.streamTypeService.searchStreamType();
		return new ModelAndView("admin/viewStreamType", "streamTypeList", streamTypeList);
	}
	@GetMapping(value = "user/searchStreamType")
	public ModelAndView usersearchStreamType() {
		List<StreamTypeVO> streamTypeList = this.streamTypeService.searchStreamType();
		return new ModelAndView("user/viewStreamType", "streamTypeList", streamTypeList);
	}

	@GetMapping(value = "admin/deleteStreamType")
	public ModelAndView deleteStreamType(@ModelAttribute StreamTypeVO streamTypeVO, @RequestParam int id) {
		streamTypeVO.setId(id);
		List<StreamTypeVO> streamTypeList = streamTypeService.searchByID(streamTypeVO);
		StreamTypeVO streamTypeVO2 = (StreamTypeVO) streamTypeList.get(0);
		streamTypeVO2.setStatus(false);
		streamTypeService.insertStreamType(streamTypeVO2);
		return new ModelAndView("redirect:/admin/searchStreamType");
	}

	@GetMapping(value = "admin/editStreamType")
	public ModelAndView editLoanType(@ModelAttribute StreamTypeVO streamTypeVO, @RequestParam int id) {
		streamTypeVO.setId(id);
		List<StreamTypeVO> streamTypeList = streamTypeService.searchByID(streamTypeVO);
		return new ModelAndView("admin/addStreamType", "StreamTypeVO", (StreamTypeVO) streamTypeList.get(0));
	}
}
