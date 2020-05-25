package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;

@Controller
@RequestMapping("/AssetGeneralView")
public class AssetGeneralViewController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, "MÀN HÌNH XEM THÔNG TIN TÀI SẢN");
		String RFID_CD = request.getParameter("rfid_code");
		if(RFID_CD != null && RFID_CD.length() >0)
		{
			AssetGeneralFormSearch asset = new AssetGeneralFormSearch();
			asset.setRFID(RFID_CD.trim());
			AssetGeneralSelectDao assetGeneralSelectDao = new AssetGeneralSelectDao(asset);
			try {
				List<AssetObject> lst = assetGeneralSelectDao.excute();
				if(lst.size() == 0)
				{
					mv.addObject(Common.MESSAGE_ERROR,"Không tìm thấy tài sản khớp với mã");
				}
				else
				{
					if(lst.size()>1)
					{
						mv.addObject(Common.MESSAGE_ERROR,"Tìm thấy 2 tài sản tương tự<br>Hãy kiểm tra lại");
					}
					else
					{
						mv.addObject("asset",lst.get(0));
						//mv.addObject(Common.MESSAGE_ERROR,"TÌM ĐƯỢC");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				mv.addObject(Common.MESSAGE_ERROR,"Lỗi trong lúc tìm tài sản");
				e.printStackTrace();
				
			}
		}
		else
		{
			mv.addObject(Common.MESSAGE_ERROR,"Không truyền mã quản lý RFID cho màn hình");
		}
		mv.setViewName("pages/AssetGeneralView.jsp");
		
		return mv;
	}
	
	@RequestMapping(params="update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) 
	{
		String RFID_CD = request.getParameter("rfid_code");
		String url="AssetGeneralUpdate?rfid_code="+RFID_CD;
		return "redirect:/" + url;
	}
	
	@RequestMapping(params="delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) 
	{
		String RFID_CD = request.getParameter("rfid_code");
		String url="AssetGeneralDelete?rfid_code="+RFID_CD;
		return "redirect:/" + url;
	}
	
	@RequestMapping(params="back", method = RequestMethod.POST)
	public String back(HttpServletRequest request) 
	{
		return "redirect:/AssetManagementGeneral";
	}

}
