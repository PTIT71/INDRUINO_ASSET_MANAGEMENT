package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SessionCommon;

@Controller
@RequestMapping("/feature")
public class MenuFeatureController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request)
	{
		String cmpn = request.getParameter("cmpn");
		if(cmpn!=null && cmpn.trim().length()>0)
		{
			request.getSession().setAttribute(Constants.SESSION_USER_CMPN_CD, cmpn);
		}
		return "pages/FeatureSystem.jsp";		
	}

}
