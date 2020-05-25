package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.InventorySessionInsertDao;
import com.asset.management.dao.UserSelectDao;
import com.asset.management.model.InventorySession;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;

@Controller
public class CreateInventorySessionAcction {
	
	@RequestMapping("CreateInventorySession")
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("TittleScreen","MÀN HÌNH TẠO PHIÊN KIỂM KÊ TÀI SẢN");
		mv.setViewName("/pages/CreateSessionInventory.jsp");
		
		return mv;
	}
	
	@RequestMapping("InsertInventorySession")
	public ModelAndView InsertInventorySession(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mv = new ModelAndView();
		
		if(request.getParameter("back") != null)
		{
			mv.setViewName("redirect:/InventorySessionInit");
			return mv;
		}
		InventorySession inventorySession =new InventorySession();
		inventorySession.setInventory_session_id(Common.getDateCurrent("YYYYMMDDHHMMSS"));
		inventorySession.setInventory_session_name(request.getParameter("name"));
		inventorySession.setInventory_start_date(request.getParameter("startdate"));
		inventorySession.setInventory_end_date(request.getParameter("enddate"));
		inventorySession.setInventory_id(request.getParameter("code"));
		int item=0;
		List<String> lstEmployeeCD = new ArrayList<String>();
		String idName = "item.emloyee[" + item + "]";
		while(request.getParameter(idName) != null)
		{
			lstEmployeeCD.add(request.getParameter(idName));
			item++;
			idName = "item.emloyee[" + item + "]";
		}
		
		InventorySessionInsertDao inventorySessionInsertDao = new InventorySessionInsertDao(inventorySession, lstEmployeeCD);
		try
		{
			inventorySessionInsertDao.Excute();
		}
		catch (Exception e) {
			// TODO: handle exception
			mv.addObject("message",e);
		}
		
		
		mv.addObject("TittleScreen","MÀN HÌNH TẠO PHIÊN KIỂM KÊ TÀI SẢN");
		mv.setViewName("/pages/CreateSessionInventory.jsp");		
		return mv;
	}
	
	
	@RequestMapping("GetUserPermission")
	@ResponseBody
	public String GetUserForPermission(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		String employee_code = request.getParameter("employee_code");
		String employee_name = request.getParameter("employee_name");
		
		UserModel user = new UserModel();
		user.setEmployee_cd(employee_code);
		user.setName(employee_name);
		
		UserSelectDao userSelectDao = new  UserSelectDao(user);
		
		try {
			List<UserModel> lstUser = userSelectDao.excute();
			if(lstUser.size() > 0)
			{
				UserModel userPermission = lstUser.get(0);
				return userPermission.getEmployment_CD().trim() + "_" + userPermission.getName().trim() + "_" +userPermission.getDepartment();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lỗi lấy user gán quyền người dùng kiểm kê");
		}
		
		return "message_Không tìm thấy nhân viên này";
	}

}
