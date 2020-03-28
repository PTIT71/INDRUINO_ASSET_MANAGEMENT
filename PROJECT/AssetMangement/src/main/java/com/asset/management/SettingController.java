package com.asset.management;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
	
	@RequestMapping("/admin-manager")
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/setting.jsp");
		
		
		return mv;
		
	
	}

}
