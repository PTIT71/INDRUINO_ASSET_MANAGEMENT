package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Common;

@Controller
public class ImportCSVAssetGeneral {
	
	@RequestMapping("/ImportCSVAssetGenneral")
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_MENU, "MÀN HÌNH NHẬP DỮ LIỆU TỪ FILE EXCEL");
		mv.setViewName("pages/ImportCSVAssetGenneral.jsp");
		
		return mv;
	}
	
//	@RequestMapping("/CreateAssetGeneral")
//	public ModelAndView inist()
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.addObject(Common.TITLE_MENU, "MÀN HÌNH TẠO MỚI TÀI SẢN");
//		mv.setViewName("page/CreateAssetGeneral.jsp");
//		
//		return mv;
//	}

}
