package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;

@Controller
@RequestMapping("/MajorManagement")
public class MajorManagementController {
	
	@RequestMapping(method =  RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String TITLE = "MÀN HÌNH QUẢN LÝ NGHIỆP VỤ";
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/MajorManagement.jsp");
		return mv;
	}

}
