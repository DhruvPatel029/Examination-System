package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;
import com.project.service.RegisterService;
import com.project.utils.Basemethods;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView loadRegister() {

		return new ModelAndView("register", "RegisterVO", new RegisterVO());
	}

	@RequestMapping(value = "/insertRegister", method = RequestMethod.POST)
	public ModelAndView goToHomePage(@ModelAttribute RegisterVO registerVO, LoginVO loginVO) {

		String password = Basemethods.generatePassword();
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		String email = loginVO.getUsername();
		Basemethods.sendMail(email, password);
		System.out.println("email id is::::::" + email);
		loginVO.setPassword(password);
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
		loginVO.setStatus(true);
		this.loginService.insertLogin(loginVO);

		registerVO.setLoginVO(loginVO);
		this.registerService.insertRegister(registerVO);

		return new ModelAndView("redirect:/");
	}

	@GetMapping("admin/viewUser")
	public ModelAndView viewUser() {
		@SuppressWarnings("unchecked")
		List<RegisterVO> userList = this.registerService.searchUsers();
		return new ModelAndView("admin/viewUser", "userList", userList);
	}

	@GetMapping(value = "admin/userActivate")
	public ModelAndView userActivate(@RequestParam("id") int id, @RequestParam String flag) {

		@SuppressWarnings("unchecked")
		List<LoginVO> loginList = this.loginService.searchLoginByID(id);
		LoginVO loginVO = loginList.get(0);
		loginVO.setEnabled(flag);
		loginVO.setId(id);
		this.loginService.insertLogin(loginVO);
		return new ModelAndView("redirect:/admin/viewUser");
	}

}
