package com.asset.management.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.CheckingAsssetNewSelectDao;
import com.asset.management.dao.InventoryCheckingSelectDao;
import com.asset.management.dao.InventorySessionSelectDao;
import com.asset.management.model.AssetObject;
import com.asset.management.model.CheckingAssetNew;
import com.asset.management.model.InventoryChecking;
import com.asset.management.model.InventorySession;
import com.asset.management.table.AssetManagementTable;
import com.asset.management.util.Common;
import com.asset.management.util.CommonSQL;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("InventoryManagement")
public class InventoryManagementContorller {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView CompanyInsert(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ KIỂM KÊ");
		String session_id = request.getParameter("InventoryID");
		mv.addObject("InventoryID", session_id);
		InventoryChecking inventoryChecking = new InventoryChecking();
		inventoryChecking.setInventorySessionCD(session_id);
	    SystemControl sys = new SystemControl(request);
	    inventoryChecking.setCompany_cd(sys.CompanyCDCurrent);
		InventoryCheckingSelectDao inventoryCheckingSelectDao = new InventoryCheckingSelectDao(inventoryChecking);
		List<AssetManagementTable> lstChecking = inventoryCheckingSelectDao.excuteAssetManagementTable();
	//	CheckingAssetNew checkingAssetNew = new CheckingAssetNew();
	//	checkingAssetNew.setChecking_session(inventoryChecking.getInventory_Session_CD());
	//	CheckingAsssetNewSelectDao checkingAsssetNewSelectDao = new CheckingAsssetNewSelectDao(checkingAssetNew);
	//	List<AssetManagementTable> lstChecking2 = checkingAsssetNewSelectDao.excuteAssetManagementTable();
//		if(lstChecking2.size()>0)
//		{
//			for(int i=0;i<lstChecking2.size();i++)
//			{
//				lstChecking.add(lstChecking2.get(i));
//			}
//		}
		if(lstChecking.size() > 0)
		{
			mv.addObject("lstChecking", lstChecking);
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "TÌM THẤY  "+ lstChecking.size() +" TÀI SẢN KIỂM KÊ");
		}
		else
		{
			mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY MÃ KIỂM KÊ NÀO");
		}
		
		
		mv.setViewName("/pages/InventoryManagement.jsp");
		
		return mv;
	}
	
	@RequestMapping(params = "search", method = RequestMethod.POST)
	public ModelAndView search(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ KIỂM KÊ");
		String session_id = request.getParameter("InventoryID");
		mv.addObject("InventoryID", session_id);
		InventoryChecking inventoryChecking = new InventoryChecking();
		inventoryChecking.setInventorySessionCD(session_id);
	    SystemControl sys = new SystemControl(request);
	    inventoryChecking.setCompany_cd(sys.CompanyCDCurrent);
	    inventoryChecking.setDepartment(request.getParameter("select_department"));
	    inventoryChecking.setAsset_name(request.getParameter("text_asset_name"));
		InventoryCheckingSelectDao inventoryCheckingSelectDao = new InventoryCheckingSelectDao(inventoryChecking);
		List<AssetManagementTable> lstChecking = inventoryCheckingSelectDao.excuteAssetManagementTable();
	//	CheckingAssetNew checkingAssetNew = new CheckingAssetNew();
	//	checkingAssetNew.setChecking_session(inventoryChecking.getInventory_Session_CD());
	//	CheckingAsssetNewSelectDao checkingAsssetNewSelectDao = new CheckingAsssetNewSelectDao(checkingAssetNew);
	//	List<AssetManagementTable> lstChecking2 = checkingAsssetNewSelectDao.excuteAssetManagementTable();
//		if(lstChecking2.size()>0)
//		{
//			for(int i=0;i<lstChecking2.size();i++)
//			{
//				lstChecking.add(lstChecking2.get(i));
//			}
//		}
		if(lstChecking.size() > 0)
		{
			mv.addObject("lstChecking", lstChecking);
			mv.addObject(Constants.MESSAGE_NOTIFICATION, "TÌM THẤY  "+ lstChecking.size() +" TÀI SẢN KIỂM KÊ");
		}
		else
		{
			mv.addObject(Common.MESSAGE_ERROR, "KHÔNG TÌM THẤY MÃ KIỂM KÊ NÀO");
		}
		
		
		mv.setViewName("/pages/InventoryManagement.jsp");
		
		return mv;
	}
	
	
}
