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

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		HttpSession session_en=request.getSession();  
		if(session_en.getAttribute("usn")!=null && session_en.getAttribute("usn").toString().trim().length()>0)
		{
			mv.setViewName("/pages/login.jsp");
		}
		else
		{
			mv.setViewName("/pages/login.jsp");
		}
		

		return mv;
	}

	@RequestMapping("/login-user")
	public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView mv = new ModelAndView();
		String usn = request.getParameter("usn");
		String pwd = request.getParameter("pswd");

		if (usn != null && usn.length() > 0) {
			if (pwd != null && usn.length() > 0) {
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
						user.setUsermame(result.getString("EMPLOYEE_CD"));
						lstUser.add(user);
					}
					
					if(lstUser.size() >0)
					{
						for(int i=0;i<lstUser.size();i++)
						{
							if(lstUser.get(i).getUsermame().trim().equals(usn.trim()) && lstUser.get(i).getPasword().trim().equals(pwd.trim()))
							{
								  HttpSession session=request.getSession();  
							      session.setAttribute("NAME",lstUser.get(i).getName());  
							      session.setAttribute("ID",lstUser.get(i).getUsermame());  
								  return "redirect:/general";
							}
							else
							{
								return "redirect:/";
							}
						}
					}
				}
			}
		}
		return "redirect:/";

	}

}
