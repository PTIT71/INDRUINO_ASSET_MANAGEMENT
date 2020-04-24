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

import com.asset.management.dao.InventorySessionPermissionSelectDao;
import com.asset.management.dao.InventorySessionSelectDao;
import com.asset.management.dao.UserDao;
import com.asset.management.dao.UserSelectDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.InventorySession;
import com.asset.management.model.InventorySessionPermission;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.CommonSQL;
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
		return mv;
	}

	@RequestMapping("/PDACheckInventory")
	public ModelAndView check(HttpServletRequest request, HttpServletResponse response) {
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
			String pa, us;
			result = stmt.executeQuery("select * from ASSETS_GENERAL WHERE ASSET_RFID = '" + rfid + "'");
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

			if (Asset.getRFID() != null && Asset.getRFID().length() > 0) {
				// Tìm thấy tài sản:
				mv.addObject("Asset", Asset);
				// Tài sản đã được kiểm kê
				// Tài sản chưa được kiểm kê
			} else {
				mv.addObject("message", "Không tìm thấy tài sản");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("pages/PDACheckoutInventory.jsp");
		return mv;
	}

}
