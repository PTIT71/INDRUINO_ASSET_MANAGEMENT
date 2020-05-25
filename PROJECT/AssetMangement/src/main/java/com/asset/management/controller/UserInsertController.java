package com.asset.management.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.UserInsertDao;
import com.asset.management.model.User;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("UserRegister")
public class UserInsertController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH THÊM TÀI KHOẢN");
		mv.setViewName("/pages/UserInsert.jsp");
		return mv;
	}

	@RequestMapping(params = "save" , method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH THÊM TÀI KHOẢN");
		UserModel user = new UserModel();
		SystemControl sys = new SystemControl(request);
		user.setCompany_cd(sys.CompanyCDCurrent);
		user.setEmployee_cd(request.getParameter("employee_code"));
		user.setName(request.getParameter("employee_name"));
		user.setPasword(request.getParameter("employee_code"));
		user.setEmployment_CD(request.getParameter("employee_code"));
		UserInsertDao usi = new UserInsertDao(user);
		try {
			usi.excute();
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "THÊM THÀNH CÔNG");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject(Common.MESSAGE_ERROR, "LỖI THÊM USER");
			e.printStackTrace();
		}
		mv.setViewName("/pages/UserInsert.jsp");
		return mv;
	}
	
	@RequestMapping(params = "back" , method = RequestMethod.POST)
	public ModelAndView back(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/UserManagement");
		return mv;
	}
}
