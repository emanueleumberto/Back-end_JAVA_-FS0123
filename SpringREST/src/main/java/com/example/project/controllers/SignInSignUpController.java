package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.models.User;
import com.example.project.services.UserService;

@Controller
public class SignInSignUpController {
	
	@Autowired UserService userService;
	
	@GetMapping("/login")
	public ModelAndView showFormLogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/register")
	public ModelAndView showFormRegister() {
		return new ModelAndView("register", "userRegister", new User());
	}
	
	@PostMapping("/register-user")
	public String submitRegister(@ModelAttribute("userRegister") User registerUser) {
		//System.out.println(registerUser);
		String s = userService.registerUser(registerUser);
		return "register-success";
	}

}
