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
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.model.AssetObject;
import com.asset.management.util.CommonSQL;

@Controller
public class InventoryManagementContorller {

	@RequestMapping("inventory")
	public String CompanyInsert(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		//modelMap.addAttribute("TittleScreen","MÀN HÌNH THÊM CÔNG TY QUẢN L�?");
		
		return "/pages/PDAInventory.jsp";
	}
	
	@RequestMapping("inventory-management-init")
	public String init(ModelMap modelMap, HttpServletRequest request) throws SQLException
	{
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN L�? KIỂM KÊ");
		
		return "/pages/InventoryManage.jsp";
	}
	
	@RequestMapping("/checkInventory")
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
	            	mv.addObject("Asset",Asset);
	            }
	            else
	            {
	            	mv.addObject("message","Không tìm thấy tài sản");
	            }
	            
	           
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        mv.setViewName("pages/PDAInventory.jsp");
		return mv;
	}
}
