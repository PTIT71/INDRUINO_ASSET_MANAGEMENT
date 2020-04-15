package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {
	
	@RequestMapping(value = "user-manage")
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/pages/UserManage.jsp");
		return mv;
		
	
	}
	@RequestMapping(value = "user-insert-init")
	public ModelAndView initInsert(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH THÊM TÀI KHOẢN");
		mv.setViewName("/pages/UserInsert.jsp");
		return mv;
		
	
	}


}
