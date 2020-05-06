package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralInsertDao;
import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.dao.AssetGeneralUpdateDao;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.model.AssetObject;
import com.asset.management.util.Common;

@Controller
@RequestMapping("/AssetGeneralUpdate")
public class AssetGeneralUpdateController {
	String TITLESCREEN = "MÀN HÌNH CHỈNH SỬA THÔNG TIN TÀI SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, String message_error, String Notification) throws ParseException
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
						if(lst.get(0).getDateStart()!=null && lst.get(0).getDateStart().trim().length()>0)
						{
							String date = lst.get(0).getDateStart();
							String dateNew = Common.ConvertStringToDateStr(date, "dd/mm/yyyy", "yyyy-mm-dd");
							lst.get(0).setDateStart(dateNew);
						}
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
		
		mv.setViewName("pages/AssetGeneralUpdate.jsp");
		
		return mv;
	}
	@RequestMapping(params="save", method=RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ParseException
	{
		request.setCharacterEncoding("UTF-8");
		AssetObject asset = new AssetObject(request);
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLESCREEN);
		
		AssetGeneralUpdateDao assetGeneralUpdateDao = new AssetGeneralUpdateDao();
		
		
		try {
			assetGeneralUpdateDao.excuteData(asset);
			mv.addObject("notification", "Cập nhật tài sản thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject("message", "Cập nhật tài sản không thành công");
			e.printStackTrace();
		}

		
		return "redirect:/AssetGeneralUpdate?update=success&rfid_code="+ asset.getRFID() ;
	}
	
	@RequestMapping(params="back", method=RequestMethod.POST)
	public String back(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ParseException
	{
		request.setCharacterEncoding("UTF-8");
		AssetObject asset = new AssetObject(request);
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLESCREEN);
		
	    String pagram = request.getParameter("asset_rfid");

		
		return "redirect:/AssetGeneralView?rfid_code="+ pagram ;
	}

}
