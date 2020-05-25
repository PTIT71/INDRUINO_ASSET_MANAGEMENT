package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.util.Constants;

@Controller
public class ErrorController {
	
	@RequestMapping("/error")
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		request.getSession().removeAttribute(Constants.SESSION_USER_NAME);
		request.getSession().removeAttribute(Constants.SESSION_USER_ID);
		request.getSession().removeAttribute(Constants.SESSION_USER_CMPN_CD);
		request.getSession().removeAttribute(Constants.SYSTEM_NAME);
		request.getSession().removeAttribute(Constants.SUB_SYSTEM_NAME);
		request.getSession().removeAttribute(Constants.SUB_SYSTEM_CD);
		mv.setViewName("pages/error.jsp");
		return mv;
	}

}
