package com.asset.management.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.InventorySessionSelectDao;
import com.asset.management.model.AssetObject;
import com.asset.management.model.InventorySession;
import com.asset.management.util.CommonSQL;

@Controller
public class InventorySessionController {
	
	
	@RequestMapping("InventorySessionInit")
	public ModelAndView init(ModelMap modelMap, HttpServletRequest request) 
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ KIỂM KÊ");
		mv.setViewName("pages/InventorySessionInit.jsp");
		
		InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();
		try {
			List<InventorySession> lstInventorySession = inventorySessionSelectDao.excute();
			if(lstInventorySession.size() > 0)
			{
				mv.addObject("lstInventorySession",lstInventorySession);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mv.addObject("message",e.toString());
		}
		
		
		return mv;
	}
	
	
}
