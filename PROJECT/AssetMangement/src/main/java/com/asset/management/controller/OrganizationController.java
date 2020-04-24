package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;

@Controller
public class OrganizationController {
	@RequestMapping("/organization")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		String NAME = "MÀN HÌNH QUẢN LÝ TỔ CHỨC";
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_MENU, NAME);
		mv.setViewName("/pages/organization.jsp");
		return mv;
	}
}
