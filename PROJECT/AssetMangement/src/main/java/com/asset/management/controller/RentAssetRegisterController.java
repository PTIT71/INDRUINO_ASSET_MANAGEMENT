package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.RentAssetInsertDao;
import com.asset.management.model.RentAsset;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;
import com.sun.corba.se.impl.orbutil.closure.Constant;

@Controller
@RequestMapping("/RentAssetRegister")
public class RentAssetRegisterController {
	
	@RequestMapping(method =  RequestMethod.GET)
	public ModelAndView init()
	{
		String TITLE = "MÀN HÌNH ĐĂNG KÝ TÀI SẢN THUÊ BÊN NGOÀI";
		ModelAndView mv  = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		mv.setViewName("pages/RentAssetRegister.jsp");
		return mv;
	}
	@RequestMapping(params = "save",method = RequestMethod.POST)
	public ModelAndView Create(HttpServletRequest request) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mv = new ModelAndView();
		RentAsset rent = new RentAsset();
		// rent_cd;
		rent.setRent_cd(Common.getDateCurrent("YYYYmmDDHHMMSS"));
		// cmpn_cd;
		SystemControl sys = new SystemControl(request);
		rent.setCmpn_cd(sys.CompanyCDCurrent);
		// dept_cd;
		rent.setDept_cd(request.getParameter("department_cd"));
		// asset_name;
		rent.setAsset_name(request.getParameter("asset_name"));
		// accountant_cd;
		rent.setAccountant_cd(request.getParameter("accountan_cd"));
		// bussiness_name;
		rent.setBussiness_name(request.getParameter("company_name"));
		// bussiness_address;
		rent.setBussiness_address(request.getParameter("company_address"));
		// rent_date;
		rent.setRent_date(request.getParameter("date_rent"));
		// paid_1;
		rent.setPaid_1(request.getParameter("date_paid"));
		// status;
		rent.setStatus("1");
		// user_insert;
		rent.setUser_insert(sys.EmployeeCD);
		rent.setRfid(request.getParameter("asset_rfid"));
		// insert_dt;
		rent.setInsert_dt(Common.getDateCurrent("YYYY/MM/DD"));
		
		RentAssetInsertDao rentAssetInsertDao = new RentAssetInsertDao(rent);
		try {
			rentAssetInsertDao.excute();
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "ĐĂNG KÝ DỮ LIỆU THUÊ TÀI SẢN THÀNH CÔNG");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject(Common.MESSAGE_ERROR, e.toString());
			mv.setViewName( "redirect:/RentAssetRegister");
			
		}
		mv.setViewName( "redirect:/RentAssetManagement");
		return mv;
	}
	
	@RequestMapping(params = "back",method = RequestMethod.POST)
	public String back()
	{
		return "redirect:/RentAssetManagement";
	}

}
