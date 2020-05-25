package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.RentAssetSelectDao;
import com.asset.management.model.RentAsset;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("/RentAssetManagement")
public class RentAssetManagement {
	
	@RequestMapping(method =  RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		String TITLE = "MÀN HÌNH QUẢN LÝ TÀI SẢN THUÊ BÊN NGOÀI";
		ModelAndView mv  = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		RentAsset rentAsset = new RentAsset();
		SystemControl sys = new SystemControl(request);
		rentAsset.setCmpn_cd(sys.CompanyCDCurrent);
		RentAssetSelectDao rentAssetSelectDao = new RentAssetSelectDao(rentAsset);
		try {
			List<RentAsset> lst = rentAssetSelectDao.excute();
			if(lst.size()==0)
			{
				mv.addObject(Constants.MESSAGE_NOTIFICATION, "KHÔNG TÌM THẤY TÀI SẢN THUÊ");
			}
			else
			{
				if(lst.size()>0)
				{
					mv.addObject(Constants.MESSAGE_NOTIFICATION, "TÌM THẤY" + lst.size() +" TÀI SẢN THUÊ");
					mv.addObject("lst", lst);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject(Common.MESSAGE_ERROR, e.toString());
		}
		mv.setViewName("pages/RentAssetManagement.jsp");
		return mv;
	}
	@RequestMapping(params = "create",method = RequestMethod.POST)
	public String Create()
	{
		return "redirect:/RentAssetRegister";
	}
	
	@RequestMapping(params = "back",method = RequestMethod.POST)
	public String back()
	{
		return "redirect:/feature";
	}

}
