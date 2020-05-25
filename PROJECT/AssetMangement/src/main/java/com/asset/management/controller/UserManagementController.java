package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("UserManagement")
public class UserManagementController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/pages/UserManage.jsp");
		return mv;
		
	
	}
	@RequestMapping(params = "create", method = RequestMethod.POST)
	public ModelAndView Insert(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/UserRegister");
		return mv;
		
	
	}
	@RequestMapping(params = "back", method = RequestMethod.POST)
	public ModelAndView Back(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/admin-manager");
		return mv;
		
	
	}


}
