package com.asset.management.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.DepartmentInsertDao;
import com.asset.management.dao.DepartmentSelectDao;
import com.asset.management.model.Department;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("/DepartmentManagement")
public class DepartmentManagement {
	String TITLE = "MÀN HÌNH ĐƠN VỊ CỦA DOANH NGHIỆP";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/DepartmentManagement.jsp");
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
		return mv;
	}
	
	@RequestMapping(params = "save" , method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		Department dept = new Department();
		SystemControl sys = new SystemControl(request);
		dept.setCompany_cd(sys.CompanyCDCurrent);
		dept.setDept_cd(Common.getDateCurrent("YYYYmmDDHHMMSS"));
		dept.setDept_name(request.getParameter("department_name"));
		dept.setDept_desciption(request.getParameter("department_describe"));
		if(Common.isNotCheckEmpty(dept.getDept_name()) == false)
		{
			mv.addObject(Common.MESSAGE_ERROR, "KHÔNG ĐƯỢC BỎ TRỐNG TÊN ĐƠN VỊ");
		}
		else
		{
			DepartmentInsertDao insert = new DepartmentInsertDao(dept);
			try {
				insert.excute();
				mv.addObject(Constants.MESSAGE_NOTIFICATION, "THÊM THÀNH CÔNG");
				mv.setViewName("redirect:/DepartmentManagement");
				return mv;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				mv.addObject(Common.MESSAGE_ERROR, "THÊM ĐƠN VỊ BỊ LỖI");
				e.printStackTrace();
			}
			
		}
		mv.setViewName("pages/DepartmentManagement.jsp");
			
			
		
		
		
		
		return mv;
	}
	
	//CompanySettingManagement
	@RequestMapping(params = "back" , method = RequestMethod.POST)
	public String back(HttpServletRequest request, Model model)
	{
		return "redirect:/CompanySettingManagement";
	}
}
