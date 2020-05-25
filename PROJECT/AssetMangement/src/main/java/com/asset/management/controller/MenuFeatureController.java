package com.asset.management.controller;

import java.io.Console;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.model.CompanyModel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SessionCommon;

@Controller
@RequestMapping("/feature")
public class MenuFeatureController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request)
	{
		String cmpn = request.getParameter("cmpn");
		if(cmpn!=null && cmpn.trim().length()>0)
		{
			String cd = (String) request.getSession().getAttribute(Constants.SESSION_USER_CMPN_CD);
			if(cd != null)				
			{
				if(cd.trim().equals(cmpn.trim()) == false)
				{
					CompanyModel cm = new CompanyModel();
					cm.setCompany_cd(cmpn);
					CompanySelectDao cmd = new CompanySelectDao(cm);
					try {
						List<CompanyModel> lst = cmd.excute();
						if(lst.size()>0)
						{
							request.getSession().setAttribute(Constants.SUB_SYSTEM_NAME,lst.get(0).getCompany_name());
							request.getSession().setAttribute(Constants.SUB_SYSTEM_CD,lst.get(0).getCompany_cd());
							System.out.println("Current compnay: " + lst.get(0).getCompany_cd());
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else
				{
					request.getSession().setAttribute(Constants.SUB_SYSTEM_NAME,null);
					request.getSession().setAttribute(Constants.SUB_SYSTEM_CD,cd.trim());
					System.out.println("Current compnay: " +cd.trim());
				}
			}
			else
			{
				request.getSession().setAttribute(Constants.SUB_SYSTEM_NAME,null);
				request.getSession().setAttribute(Constants.SUB_SYSTEM_CD,cd.trim());
				System.out.println("Current compnay: " +cd.trim());
			}
		}
		else
		{
			request.getSession().setAttribute(Constants.SUB_SYSTEM_NAME,null);
			return "redirect:/error";	
		}
		return "pages/FeatureSystem.jsp";		
	}

}
