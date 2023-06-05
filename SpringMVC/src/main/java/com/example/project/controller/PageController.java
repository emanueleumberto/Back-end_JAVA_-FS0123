package com.example.project.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.websocket.server.PathParam;

@Controller
public class PageController {
	
	@GetMapping("/home")
	public @ResponseBody String getHomePage() {
		return "Prima pagina MVC Spring";
	}
	
	@GetMapping("/home/param")
	public @ResponseBody String getHomePageParamsQueryString(@RequestParam String test, @RequestParam String nome) {
		return "Prima pagina MVC Spring con parametro Query String: " + test;
	}
	
	@GetMapping("/home/param/{test}/{nome}")
	public @ResponseBody String getHomePageParamsPathParam(@PathVariable String test, @PathVariable String nome ) {
		return "Prima pagina MVC Spring con parametro Path Variable: " + test;
	}
	
	@GetMapping("/page1/{fullname}/{city}")
	public String getPage(Map<String, Object> model, @PathVariable String fullname, @PathVariable String city) {
		model.put("fullname", fullname);
		model.put("city", city);
		return "pageThymeleaf";
	}
	
	@GetMapping("/page2/{fullname}/{city}")
	public String getPage(Model model, @PathVariable String fullname, @PathVariable String city) {
		model.addAttribute("fullname", fullname);
		model.addAttribute("city", city);
		return "pageThymeleaf";
	}
	
	@GetMapping("/page3/{fullname}/{city}")
	public String getPage(ModelMap model, @PathVariable String fullname, @PathVariable String city) {
		model.addAttribute("fullname", fullname);
		model.addAttribute("city", city);
		return "pageThymeleaf";
	}
	
	@GetMapping("/page4/{fullname}/{city}")
	public ModelAndView getPage(@PathVariable String fullname, @PathVariable String city) {
		String page = "pageThymeleaf";
		ModelAndView model = new ModelAndView(page);
		model.addObject("fullname", fullname);
		model.addObject("city", city);
		return model;
	}

}
