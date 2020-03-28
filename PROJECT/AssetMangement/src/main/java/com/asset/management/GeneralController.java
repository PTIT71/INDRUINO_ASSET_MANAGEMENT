package com.asset.management;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {
	
	
	@RequestMapping("/manager")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("pages/general.jsp");		
		return mv;	
	}
	

}
