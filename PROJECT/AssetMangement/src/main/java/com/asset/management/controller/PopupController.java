package com.asset.management.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.dao.DepartmentSelectDao;
import com.asset.management.model.CompanyModel;
import com.asset.management.model.Department;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
public class PopupController {
	
	@RequestMapping("/GetListDepartment")
	public ModelAndView GetListDepartment(HttpServletRequest request)
	{
		String TITLE = "DANH SÁCH CÁC ĐƠN VỊ TRONG DOANH NGHIỆP";
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		Department dept = new Department();
		SystemControl sys = new SystemControl(request);
		dept.setCompany_cd(sys.CompanyCDCurrent);
		DepartmentSelectDao departmentSelectDao = new DepartmentSelectDao(dept);
		List<Department> lstDept = new ArrayList<Department>();
		
		try {
			lstDept = departmentSelectDao.excute();
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "Tìm thấy " + lstDept.size() + " đơn vị");
			if(lstDept.size()>0)
			{
				mv.addObject("lst", lstDept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject(Common.MESSAGE_ERROR, e.toString());
		}
		mv.setViewName("pages/PopupGetListDepartment.jsp");
		
		return mv;
	}
	
	@RequestMapping("/GetListCompanyTable")
	public ModelAndView GetListCompany(HttpServletRequest request)
	{
		String TITLE = "DANH SÁCH CÁC  DOANH NGHIỆP";
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		CompanySelectDao cmpny = new CompanySelectDao();
		List<CompanyModel> lstCmpn = new ArrayList<CompanyModel>();
		
		try {
			lstCmpn = cmpny.excute();
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "Tìm thấy " + lstCmpn.size() + " công ty");
			if(lstCmpn.size()>0)
			{
				mv.addObject("lst", lstCmpn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject(Common.MESSAGE_ERROR, e.toString());
		}
		mv.setViewName("pages/PopupGetListCompanyTable.jsp");
		
		return mv;
	}

}
