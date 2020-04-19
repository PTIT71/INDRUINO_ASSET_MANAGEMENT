package com.asset.management.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.InventorySessionSelectDao;
import com.asset.management.dao.UserDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.InventorySession;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.CommonSQL;
import com.asset.management.util.LocationDirection;
import com.asset.management.util.UrlRedirection;

@Controller
public class PDACheckoutInventoryController {

	@RequestMapping("inventory")
	public ModelAndView CompanyInsert(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/PDAInventory.jsp");
		
		InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();
		
		List<InventorySession> lstInventory = new ArrayList<InventorySession>();
		lstInventory = inventorySessionSelectDao.excute();
		
		if(lstInventory.size()>0)
		{
			mv.addObject("lstInventory",lstInventory);
		}
		
		return mv;
	}
	@RequestMapping("/checkout")
	public String init(HttpServletRequest request, HttpServletResponse response) {
		
		return "/pages/PDACheckoutInventory.jsp";
	}
	
	@RequestMapping("/PDACheckInventory")
	public ModelAndView check(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		String rfid = request.getParameter("rfid");
		 Connection conn = null;
	       
	        Statement stmt = null;
	        ResultSet result = null;
	        List<T> results = new ArrayList<T>();
	        try {
	            Class.forName(CommonSQL.DRIVERSQLSERVER).newInstance();
	            conn = DriverManager.getConnection(CommonSQL.DB_URL, CommonSQL.DB_USER, CommonSQL.DB_PASS);
	            stmt = conn.createStatement();
	            result = null;
	            String pa,us;
	            result = stmt.executeQuery("select * from ASSETS_GENERAL WHERE ASSET_RFID = '" + rfid+"'" );
	            AssetObject Asset = new AssetObject();
	            while (result.next()) {
	    			Asset.setRFID(result.getString("ASSET_RFID"));
	    			Asset.setName(result.getString("ASSET_NAME"));
	    			Asset.setModel(result.getString("ASSET_MODEL"));
	    			Asset.setSeries(result.getString("ASSET_SERIES"));
	    			Asset.setDepartment(result.getString("ASSET_DEPARTMENT"));
	    			Asset.setAccountant_CD(result.getString("ASSET_ACCOUNTANT"));
	    			Asset.setDateStart(result.getString("ASSET_DATE_INVEST"));
	    			Asset.setPrice(result.getString("ASSET_PRICE"));
	    			Asset.setNote(result.getString("ASSET_NOTE"));
	    		}
	            
	            if(Asset.getRFID()!=null && Asset.getRFID().length()>0)
	            {
	            	//Tìm thấy tài sản:
	            	mv.addObject("Asset",Asset);
	            	//Tài sản đã được kiểm kê
	            	//Tài sản chưa được kiểm kê
	            }
	            else
	            {
	            	mv.addObject("message","Không tìm thấy tài sản");
	            }
	            
	           
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        mv.setViewName("pages/PDACheckoutInventory.jsp");
		return mv;
	}
	
	

}
