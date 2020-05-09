package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.form.CompanyForm;
import com.asset.management.model.CompanyModel;
import com.asset.management.util.Common;

@Controller
public class OrganizationController {
	@RequestMapping("/organization")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		String NAME = "MÀN HÌNH QUẢN LÝ TỔ CHỨC";
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, NAME);
		CompanySelectDao companySelectDao = new CompanySelectDao();
		try {
			List<CompanyModel> lstCompanyForms =  companySelectDao.excute();
			if(lstCompanyForms.size()>0)
			{
				mv.addObject("lstCompany", lstCompanyForms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject(Common.MESSAGE_ERROR, "LỖI LOAD CÔNG TY");
		}
		mv.setViewName("/pages/organization.jsp");
		return mv;
	}
}
