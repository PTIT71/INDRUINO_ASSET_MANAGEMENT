package com.asset.management.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.UserDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.LocationDirection;
import com.asset.management.util.UrlRedirection;

@Controller
public class CheckoutInventoryController {

	/**
	 * @author THINH.PVP
	 * Hàm init khi vào hệ thống, trang đăng nhập
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkout")
	public String init(HttpServletRequest request, HttpServletResponse response) {
		
		return "/pages/CheckoutInventory.jsp";
	}
	
	

}
