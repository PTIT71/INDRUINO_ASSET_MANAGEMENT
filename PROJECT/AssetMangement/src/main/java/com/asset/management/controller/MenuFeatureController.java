package com.asset.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuFeatureController {
	
	@RequestMapping("/feature")
	public String init()
	{
		return "pages/FeatureSystem.jsp";		
	}

}
