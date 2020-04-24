package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralInsertDao;
import com.asset.management.model.AssetObject;
import com.asset.management.util.Common;

@Controller
@RequestMapping("/CreateAssetGeneral")
public class CreateAssetGeneralController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_MENU, "MÀN HÌNH TẠO MỚI TÀI SẢN");
		mv.setViewName("/pages/CreateAssetGeneral.jsp");
		return mv;
	}
	@RequestMapping(params="save", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		AssetObject asset = new AssetObject(request);
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_MENU, "MÀN HÌNH TẠO MỚI TÀI SẢN");
//		AssetObject asset = new AssetObject();
//		asset.setName(request.getParameter("asset_name"));
//		asset.setRFID(request.getParameter("asset_rfid"));
//		asset.setAccountant_CD(request.getParameter("asset_accountant"));
//		asset.setModel(request.getParameter("asset_model"));
//		asset.setSeries(request.getParameter("asset_series"));
//		asset.setDepartment(request.getParameter("asset_department"));
//		asset.setDateStart(request.getParameter("asset_date"));
//		asset.setNote(request.getParameter("asset_note"));
//		asset.setPrice(request.getParameter("asset_price"));
		
		AssetGeneralInsertDao assetGeneralInsertDao = new AssetGeneralInsertDao();
		
		try {
			assetGeneralInsertDao.excuteData(asset);
			mv.addObject("notification", "Thêm tài sản thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mv.addObject("message", "Thêm tài sản không thành công");
			e.printStackTrace();
		}
		
		
		
		mv.setViewName("/pages/CreateAssetGeneral.jsp");
		return mv;
	}
	@RequestMapping(params="back", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
	public String back(HttpServletRequest request, HttpServletResponse response)
	{
		return "redirect:/AssetManagementGeneral";
	}
}
