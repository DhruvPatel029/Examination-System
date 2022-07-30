package com.project.controller;
 
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplainVO;
import com.project.model.LoginVO;
import com.project.service.ComplainService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;


@Controller
// @RequestMapping(value="user/")
public class ComplainController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ComplainService complainService;

	@GetMapping(value = "user/loadComplaint")
	public ModelAndView loadComplain(@ModelAttribute ComplainVO complainVO) 
	{
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		/*System.out.println(userName);*/
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complainVO.setLoginVO(loginVO2);
		
		List complaintList = this.complainService.searchComplaint(complainVO);
	
		System.out.println("List size" + complaintList.size());

			System.out.println(complaintList.size());
 
		return new ModelAndView("user/addComplain", "ComplainVO", new ComplainVO()).addObject("complaintList",complaintList);
	}

	@PostMapping(value = "/user/addcomplaint")
	public ModelAndView insertComplain(@ModelAttribute ComplainVO complainVO, @RequestParam MultipartFile file,
			HttpSession session) {
		System.out.println("complain Controlller:::::::::::::::::::::::::::::");
		String path = session.getServletContext().getRealPath("/");
		String finalPath = path + "documents/complaint/";

		String fileName = file.getOriginalFilename();

		try {
			byte[] b = file.getBytes();

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(finalPath + fileName));

			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String userName = Basemethods.getUser();
		LoginVO loginVO2 = new LoginVO();
		List userList = this.loginService.searchLoginID(userName);
		loginVO2 = (LoginVO) userList.get(0);
		complainVO.setLoginVO(loginVO2);
		complainVO.setComplainStatus("pending");
		complainVO.setStatus(true);
		complainVO.setFileName(fileName);
		complainVO.setFilePath(finalPath);
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		complainVO.setComplainDate(dateFormat.format(d));

		this.complainService.insertComplain(complainVO);
		return new ModelAndView("redirect:/user/loadComplaint");
	}

	@GetMapping(value = "admin/adminViewComplaint")
	public ModelAndView viewComplain() {

		List complaintList = this.complainService.adminViewComplain();

		System.out.println("List size" + complaintList.size());

		return new ModelAndView("admin/viewComplaint", "complaintList", complaintList);

	}
	@GetMapping(value="admin/replytoUser")
	public ModelAndView loadReply(@RequestParam("id") int id,@ModelAttribute ComplainVO complainVO) {
		
		System.out.println(id);
		
		complainVO.setComplainId(id);
		
		List complaintList = this.complainService.SearchByID(complainVO);
		
		return new ModelAndView("admin/addReply","ComplainVO",complaintList.get(0));
	}
	@PostMapping(value="admin/insertReply")
	public ModelAndView insertReply(@ModelAttribute ComplainVO complainVO) {
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		complainVO.setReplyDate(dateFormat.format(d));
		complainVO.setComplainStatus("resolved");
		
		this.complainService.insertComplain(complainVO);
		
		return new ModelAndView("redirect:/admin/adminViewComplaint");
	}

	
	@GetMapping(value = "user/userViewComplain")
	public ModelAndView userViewComplain(@ModelAttribute ComplainVO complainVO) {

	

		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		/*System.out.println(userName);*/
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complainVO.setLoginVO(loginVO2);
		
		List complaintList = this.complainService.searchComplaint(complainVO);
	
		System.out.println("List size" + complaintList.size());

		return new ModelAndView("redirect:/user/addcomplaint").addObject("complaintList",complaintList);

	}

	 

}
