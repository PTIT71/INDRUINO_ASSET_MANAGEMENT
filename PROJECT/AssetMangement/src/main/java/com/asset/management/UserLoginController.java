package com.asset.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.UserDao;
import com.asset.management.database.DatabaseConnection;
import com.asset.management.model.UserModel;
import com.asset.management.util.Common;
import com.asset.management.util.LocationDirection;
import com.asset.management.util.UrlRedirection;

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
		//Kiểm tra session có đang lưu trữ dữ liệu người dung hay không.
		//Nếu có liền xóa đi. Nhầm đảm bảo tính bảo mật người dùng.
		HttpSession session_en=request.getSession();  
		if(session_en.getAttribute("NAME")!=null && session_en.getAttribute("NAME").toString().trim().length()>0)
		{
			session_en.setAttribute("NAME",null);
			
		}
		mv.setViewName(LocationDirection.LOGIN_LOCATE);
		return mv;
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
				DatabaseConnection conn = new DatabaseConnection();
				Connection connectString = conn.getConnection();
				if (connectString != null) {
					Statement stmt = connectString.createStatement();
					ResultSet result = null;
					UserDao userDao = new UserDao();
					result = stmt.executeQuery(userDao.getUserDao());
					ArrayList<UserModel> lstUser =new ArrayList<UserModel>();
					while (result.next()) {
						UserModel user = new UserModel();
						user.setName(result.getString("NAME"));
						user.setPasword(result.getString("PASSWORD"));
					//	user.setUsermame(result.getString("EMPLOYEE_CD"));
						lstUser.add(user);
					}
					
					if(lstUser.size() >0)
					{
						for(int i=0;i<lstUser.size();i++)
						{
							/*
							 * if(lstUser.get(i).getUsermame().trim().equals(usn.trim()) &&
							 * lstUser.get(i).getPasword().trim().equals(pwd.trim())) { HttpSession
							 * session=request.getSession();
							 * session.setAttribute("NAME",lstUser.get(i).getName());
							 * session.setAttribute("ID",lstUser.get(i).getUsermame()); String url =
							 * UrlRedirection.REDIRECT+UrlRedirection.FEATURE_SYSTEM; mv.setViewName(url);
							 * return mv; } else {
							 * mv.addObject("message","Tài khoản đăng nhập không hợp lệ !"); String url =
							 * LocationDirection.LOGIN_LOCATE; mv.setViewName(url); return mv; }
							 */
						}
					}
				}
			}
		}
		mv.addObject("message","Xin nhập đầy đủ thông tin!");
		String url = LocationDirection.LOGIN_LOCATE;
		mv.setViewName(url);
		return mv;

	}

}
