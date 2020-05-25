package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;
import com.asset.management.util.Constants;

@Controller
@RequestMapping("/CompanySettingManagement")
public class CompanySettingManagementController {
	String TITLE = "MÀN HÌNH QUẢN TRỊ DOANH NGHIỆP";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/CompanySettingManagement.jsp");
		return mv;
	}

}
