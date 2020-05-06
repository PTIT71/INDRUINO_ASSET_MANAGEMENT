package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;

@Controller
@RequestMapping("/BorrowAssetRegister")
public class BorrowAssetRegister {
	String TITLE = "MÀN HÌNH ĐĂNG KÝ MƯỢN TÀI SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/BorrowAssetRegisterInit.jsp");
		return mv;
	}

}
