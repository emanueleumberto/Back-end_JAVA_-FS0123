package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.models.User;
import com.example.project.services.UserService;

@Controller
public class SignInSignUpController {
	
	// Inject UserService
	@Autowired UserService userService;
	
	@GetMapping("/login")
	public ModelAndView showFormLogin() {
		return new ModelAndView("login", "userLogin", new User());
	}
	
	@GetMapping("/register")
	public ModelAndView showFormRegister() {
		// ModelAndView(templateHTML, NomeOBJ, OBJ)
		return new ModelAndView("register", "userRegister", new User());
	}
	
	@PostMapping("/register-user")
	public String submitRegister(
				@ModelAttribute("userRegister") User registerUser,
				ModelMap model
			) {
		// @ModelAttribute(NomeOBJdaTemplateHTML) Type obj
		//System.out.println(registerUser);
		String s = userService.registerUser(registerUser);
		model.addAttribute("userRegister", s);
		return "response-success";
	}
	
	@PostMapping("/login-user")
	public String submitLogin(
				@ModelAttribute("userLogin") User loginUser,
				ModelMap model
			) {
		//System.out.println(loginUser);
		String s = userService.loginUser(loginUser);
		model.addAttribute("userRegister", s);
		return "response-success";
	}

}
