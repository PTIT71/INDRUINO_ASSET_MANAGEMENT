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

import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.dao.CheckingInventoryInsertDao;
import com.asset.management.dao.InventoryCheckingSelectDao;
import com.asset.management.dao.InventorySessionPermissionSelectDao;
import com.asset.management.dao.InventorySessionSelectDao;
import com.asset.management.dao.UserDao;
import com.asset.management.dao.UserSelectDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.InventoryChecking;
import com.asset.management.model.InventorySession;
import com.asset.management.model.InventorySessionPermission;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.CommonSQL;
import com.asset.management.util.Constants;
import com.asset.management.util.LocationDirection;
import com.asset.management.util.UrlRedirection;

@Controller
public class PDACheckoutInventoryController {

	@RequestMapping("inventory")
	public ModelAndView CompanyInsert(ModelMap modelMap, HttpServletRequest request) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pages/PDAInventory.jsp");

		InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();

		List<InventorySession> lstInventory = new ArrayList<InventorySession>();
		lstInventory = inventorySessionSelectDao.excute();

		if (lstInventory.size() > 0) {
			mv.addObject("lstInventory", lstInventory);
		}

		return mv;
	}

	@RequestMapping("/checkout")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView mv = new ModelAndView();
		String Session_ID = request.getParameter("id_session");
		String usn = request.getParameter("username");
		String pwd = request.getParameter("password");

		// Kiểm tra là có đúng password hay không?
		// Kiểm tra tính hợp lệ
		// Kiểm tra username rỗng
		if (usn != null && usn.length() > 0) {
			// Kiểm tra password rỗng
			if (pwd != null && pwd.length() > 0) {

				UserModel user = new UserModel();
				user.setEmployee_cd(usn);
				user.setPasword(pwd);
				UserSelectDao userSelectDao = new UserSelectDao(user);

				List<UserModel> userModel = userSelectDao.excute();

				if (userModel.size() > 0) {
					InventorySessionPermission inventorySessionPermission = new InventorySessionPermission();
					inventorySessionPermission.setEmployee_id(userModel.get(0).employee_cd);
					inventorySessionPermission.setInventory_session_id(Session_ID);
					InventorySessionPermissionSelectDao inventorySessionPermissionSelectDao = new InventorySessionPermissionSelectDao(
							inventorySessionPermission);
					List<InventorySessionPermission> lst = inventorySessionPermissionSelectDao.excute();
					if (lst.size() > 0) {
						mv.addObject("session_id", Session_ID);
						mv.setViewName("pages/PDACheckoutInventory.jsp");
					} else {
						InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();

						List<InventorySession> lstInventory = new ArrayList<InventorySession>();
						lstInventory = inventorySessionSelectDao.excute();

						if (lstInventory.size() > 0) {
							mv.addObject("lstInventory", lstInventory);
						}
						mv.addObject("message", "Bạn không có quyền sử dụng chức năng này!!");
						mv.setViewName("pages/PDAInventory.jsp");
					}
				} else {
					InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();

					List<InventorySession> lstInventory = new ArrayList<InventorySession>();
					lstInventory = inventorySessionSelectDao.excute();

					if (lstInventory.size() > 0) {
						mv.addObject("lstInventory", lstInventory);
					}
					mv.addObject("message", "Mật khẩu và tài khoản không đúng");
					mv.setViewName("pages/PDAInventory.jsp");
				}
			}
			else
			{
				InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();

				List<InventorySession> lstInventory = new ArrayList<InventorySession>();
				lstInventory = inventorySessionSelectDao.excute();

				if (lstInventory.size() > 0) {
					mv.addObject("lstInventory", lstInventory);
				}
				mv.addObject("message", "Mật khẩu là bắt buộc");
				mv.setViewName("pages/PDAInventory.jsp");
			}
		}
		else
		{
			InventorySessionSelectDao inventorySessionSelectDao = new InventorySessionSelectDao();

			List<InventorySession> lstInventory = new ArrayList<InventorySession>();
			lstInventory = inventorySessionSelectDao.excute();

			if (lstInventory.size() > 0) {
				mv.addObject("lstInventory", lstInventory);
			}
			mv.addObject("message", "Tên đăng nhập là bắt buộc");
			mv.setViewName("pages/PDAInventory.jsp");
		}
		mv.addObject("session_id", Session_ID);
		return mv;
	}

	@RequestMapping("/PDACheckInventory")
	public ModelAndView check(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String rfid = request.getParameter("rfid");
		String inventory_session_id = request.getParameter("InventorySessionCD");
		AssetGeneralFormSearch assetForm = new AssetGeneralFormSearch();
		assetForm.setRFID(rfid);
		InventoryChecking inventoryChecking = new InventoryChecking();
		inventoryChecking.setAsset_Rfid(rfid);
		inventoryChecking.setInventorySessionCD(inventory_session_id);
		AssetGeneralSelectDao assetGeneralSelectDao = new AssetGeneralSelectDao(assetForm);
		
		try {
			List<AssetObject> lstAsset = assetGeneralSelectDao.excute();
			if (lstAsset.size()  > 0) {
				if(lstAsset.size()==1)
				{
					//Check xem thử nó đã được kiểm kê chưa:
					if(isNotExistInventoryChecking(inventoryChecking))
					{
						inventoryChecking.setInventorySessionChecking_CD(Common.getDateCurrent("YYYYMMDDHHMMSS"));
						HttpSession session =  request.getSession();
						String user = (String) session.getAttribute(Constants.SESSION_USER_ID);
						inventoryChecking.setUserChecking(user);
						inventoryChecking.setInventory_Date(Common.getDateCurrent("dd/mm/yyyy"));
						inventoryChecking.setStatus("1");
						CheckingInventoryInsertDao checkingInventoryInsertDao = new CheckingInventoryInsertDao(inventoryChecking);
						try
						{
							checkingInventoryInsertDao.excute();
							mv.addObject("Asset", lstAsset.get(0));
						}
						catch(Exception e)
						{
							mv.addObject(Common.MESSAGE_ERROR, "KIỂM KÊ TÀI SẢN LỖI");
						}	
					}
					else
					{
						mv.addObject(Common.MESSAGE_ERROR, "TÀI SẢN NÀY ĐÃ ĐƯỢC KIỂM KÊ TRƯỚC ĐÓ");
					}
				}
				else
				{
					mv.addObject(Common.MESSAGE_ERROR, "Tìm thấy nhiều hơn 1 tài sản tương tự<br>Hãy kiểm tra lại");
				}
			} else {
				mv.addObject("message", "Không tìm thấy tài sản");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			mv.addObject("message", e1.toString());
		}
		mv.addObject("session_id", inventory_session_id);
		mv.setViewName("pages/PDACheckoutInventory.jsp");
		return mv;
	}

	private boolean isNotExistInventoryChecking(InventoryChecking inventoryChecking) {
		
		
		InventoryCheckingSelectDao inventoryCheckingSelectDao = new InventoryCheckingSelectDao(inventoryChecking);
		try {
			List<InventoryChecking> lstInvChecking = inventoryCheckingSelectDao.excute();
			if(lstInvChecking.size() > 0)
			{
				return false;
			}
			else
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
