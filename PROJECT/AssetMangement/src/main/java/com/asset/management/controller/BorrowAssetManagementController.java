package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;
@Controller
@RequestMapping("/BorrowAssetManagement")
public class BorrowAssetManagementController {
	String TITLE = "MÀN HÌNH QUẢN LÝ MƯỢN TÀI SẢN SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/BorrowAssetManagement.jsp");
		return mv;
	}
	
	@RequestMapping(params = "create",method = RequestMethod.POST)
	public String Create()
	{
		return "redirect:/BorrowAssetRegister";
	}
}
