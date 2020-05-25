package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.BorrowAssetSelectDao;
import com.asset.management.dao.LoanAssetSelectDao;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.model.LoanAssetModel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("/LoanAssetManagement")
public class LoanAssetManagement {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv =new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, "MÀN HÌNH QUẢN LÝ TÀI SẢN CHO MƯỢN");
		LoanAssetModel br  = new LoanAssetModel();
		SystemControl systemControl = new SystemControl(request);  
		br.setBorrow_cmpn_cd(systemControl.CompanyCDCurrent);
		LoanAssetSelectDao BASD = new LoanAssetSelectDao(br);
		
		try {
			List<LoanAssetModel> lst = BASD.excute();
			if(lst.size()==0)
			{
				mv.addObject(Constants.MESSAGE_NOTIFICATION, "KHÔNG CÓ THẤY TÀI SẢN MƯỢN NÀO ĐƯỢC TÌM THẤY");
			}
			else
			{
				mv.addObject(Constants.MESSAGE_NOTIFICATION, "TÌM THẤY "+lst.size()+ " TÀI SẢN MƯỢN ĐƯỢC TÌM THẤY");
				mv.addObject("lst", lst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mv.addObject(Common.MESSAGE_ERROR, "LỖI TÌM DỮ LIỆU : " + e.toString());
		}
		mv.setViewName("pages/LoanAssetManagement.jsp");
		return mv;
	}
	
	@RequestMapping(params = "create",method = RequestMethod.POST)
	public String Create()
	{
		return "redirect:/LoanAssetRegister";
	}
	
	@RequestMapping(params = "back",method = RequestMethod.POST)
	public String back()
	{
		return "redirect:/feature";
	}

}
