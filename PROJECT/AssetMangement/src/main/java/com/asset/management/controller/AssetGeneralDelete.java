package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralDeleteUpdateDao;
import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.dao.AssetGeneralUpdateDao;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.model.AssetObject;
import com.asset.management.util.Common;

@Controller
@RequestMapping("/AssetGeneralDelete")
public class AssetGeneralDelete {
	
	String TITLESCREEN = "MÀN HÌNH XÓA THÔNG TIN TÀI SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, String message_error, String Notification)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLESCREEN);
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
						mv.addObject(Common.MESSAGE_ERROR,"ĐÂY LÀ HÀNH ĐỘNG MANG TÍNH CẨN TRỌNG");
						mv.addObject("asset",lst.get(0));
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
		
		mv.setViewName("pages/AssetGeneralDelete.jsp");
		
		return mv;
	}
	@RequestMapping(params="delete", method=RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		AssetObject asset = new AssetObject();
		String reason = request.getParameter("reason_delete");
		String RFID_CD = request.getParameter("rfid_code");
		asset.setRFID(RFID_CD);
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLESCREEN);
		
		AssetGeneralDeleteUpdateDao assetGeneralDeleteUpdateDao = new AssetGeneralDeleteUpdateDao();
		
		
		try {
			assetGeneralDeleteUpdateDao.excuteUpdateDeleteData(asset, reason);
			mv.addObject("notification", "Xóa tài sản thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject("message", "Xóa tài sản không thành công");
			e.printStackTrace();
		}

		
		return "redirect:/AssetGeneralDelete?rfid_code="+ asset.getRFID() ;
	}
	
	@RequestMapping(params="back", method=RequestMethod.POST)
	public String back(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		return "redirect:/AssetManagementGeneral" ;
	}

}
