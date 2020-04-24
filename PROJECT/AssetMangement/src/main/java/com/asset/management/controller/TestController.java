package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.model.CompanyModel;

@Controller
public class TestController {
	@RequestMapping("thinhkhung")
	public String init(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN LÝ CÔNG TY");
	
		
		return "/pages/CompanyManage.jsp";
	}

}
