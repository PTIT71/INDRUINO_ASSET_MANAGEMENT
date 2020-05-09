package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;

@Controller
@RequestMapping("/UserRightManagement")
public class UserRightManagementController {
	
	String TITLE = "MÀN HÌNH QUẢN LÝ QUYỀN NGƯỜI DÙNG";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("/pages/UserRightManagement.jsp");
		return mv;
	}

}
