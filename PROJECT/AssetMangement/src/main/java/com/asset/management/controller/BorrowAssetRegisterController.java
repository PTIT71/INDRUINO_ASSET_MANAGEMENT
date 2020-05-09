package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.model.CompanyModel;
import com.asset.management.util.Common;
import com.asset.management.util.SessionCommon;
import com.sun.org.apache.regexp.internal.recompile;
@Controller
@RequestMapping("/BorrowAssetRegister")
public class BorrowAssetRegisterController {
	String TITLE = "MÀN HÌNH ĐĂNG KÝ MƯỢN TÀI SẢN SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		String error = "";
		CompanySelectDao companySelectDao = new CompanySelectDao();
		try {
			List<CompanyModel> lstcmp = companySelectDao.excute();
			if(lstcmp.size()>0)
			{
				mv.addObject(Common.LIST_COMPANY, lstcmp);
			}
			else
			{
				error = error + "Không tìm thấy công ty nào";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error = error + e.toString() + "<br>Lỗi tìm kiếm công ty <br>";
		}
		
		String cmpn_cd = (String) request.getSession().getAttribute(SessionCommon.SESSION_USER_CMPN_CD);
		CompanyModel cm = new CompanyModel();
		cm.setCompany_cd(cmpn_cd);
	    CompanySelectDao cmCompanySelectDao = new CompanySelectDao(cm);
	    try {
			List<CompanyModel> lst = cmCompanySelectDao.excute();
			if(lst.size()>0)
			{
				mv.addObject("borrow_cmpn_cd", lst.get(0).getCompany_cd());
				mv.addObject("borrow_cmpn_na", lst.get(0).getCompany_name());
			}
		} catch (SQLException e) {
			error = error+"Không tìm thấy công ty mượn tài sản<br>";
		}
		if(error.trim().length()>0)
		{
			mv.addObject(Common.MESSAGE_ERROR, error);
		}
		mv.setViewName("pages/BorrowAssetRegister.jsp");
		return mv;
	}
	
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public ModelAndView save()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/BorrowAssetRegister.jsp");
		return mv;
	}
	
	@RequestMapping(params = "back", method = RequestMethod.POST)
	public String back()
	{
		return "redirect:/BorrowAssetManagement";
	}
}
