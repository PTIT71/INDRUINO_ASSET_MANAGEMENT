package com.asset.management.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.UserDao;
import com.asset.management.dao.UserSelectDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.LocationDirection;
import com.asset.management.util.SystemControl;
import com.asset.management.util.UrlRedirection;
import com.sun.corba.se.impl.orbutil.closure.Constant;

@Controller
public class UserLoginController {

	/**
	 * @author THINH.PVP
	 * Hàm init khi vào hệ thống, trang đăng nhập
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//Kiểm tra session có đang lưu trữ dữ liệu ngư�?i dung hay không.
		//Nếu có li�?n xóa đi. Nhầm đảm bảo tính bảo mật ngư�?i dùng.
		HttpSession session_en=request.getSession();  
		if(session_en.getAttribute("NAME")!=null && session_en.getAttribute("NAME").toString().trim().length()>0)
		{
			session_en.setAttribute("NAME",null);
			
		}
		mv.setViewName(LocationDirection.LOGIN_LOCATE);
		return mv;
	}
	
	@RequestMapping("/testajax")
	@ResponseBody
	public String inits( @ModelAttribute(value="excelFile") ExcelFile excelFile, HttpServletRequest request, HttpServletResponse response) {
		File file = null;
		try
		{
			 file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, true, "images",request.getSession());
 			System.out.println(file.getPath());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//return "./resources/images/ic_viettien.png";
		return file.getName();
	}
	
	
	/**
	 * @author THINH.PVP
	 * Hàm submit khi đăng nhập
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 */

	@RequestMapping("/login-user")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView mv = new ModelAndView();
		//Lấy giá trị nhập vào
		String usn = request.getParameter("usn");
		String pwd = request.getParameter("pswd");

		//Kiểm tra tính hợp lệ
		//Kiểm tra username rỗng
		if (usn != null && usn.length() > 0) {
			//Kiểm tra password rỗng
			if (pwd != null && pwd.length() > 0) {
				
				UserModel user = new UserModel();
				user.setPasword(pwd);
				user.setEmployee_cd(usn);
				UserSelectDao userSelectDao = new UserSelectDao(user);
				List<UserModel> lstUser = userSelectDao.excute();

					if(lstUser.size() >0)
					{
						
					  HttpSession session=request.getSession();
					  //Lưu tên trong session
					  session.setAttribute(Constants.SESSION_USER_NAME,lstUser.get(0).getName());
					  //Lưu Mã nhân viên trong session
					  session.setAttribute(Constants.SESSION_USER_ID,lstUser.get(0).getEmployment_CD()); 
					  String url = UrlRedirection.REDIRECT+UrlRedirection.FEATURE_SYSTEM; mv.setViewName(url);
					  session.setAttribute(Constants.SESSION_USER_CMPN_CD,lstUser.get(0).getCompany_cd()); 
					  return mv; 
							 
						
					}
					else 
					{
						 mv.addObject("message","Tài khoản đăng nhập không hợp lệ !"); String url =
						 LocationDirection.LOGIN_LOCATE; mv.setViewName(url); return mv; 
					}
						 
					
				}
		}
		mv.addObject("message","Xin nhập đầy đủ thông tin!");
		String url = LocationDirection.LOGIN_LOCATE;
		mv.setViewName(url);
		return mv;

	}

}
