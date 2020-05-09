package com.asset.management.Ajax;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asset.management.dao.CompanySelectDao;
import com.asset.management.model.CompanyModel;

@Controller
public class CompanyAjaxController {
	
	@RequestMapping(value = "/GetNameCompany", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getCompany(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/plain;charset=UTF-8");
		String mode = request.getParameter("mode");
		String result="";
		switch (mode) {
		case "ID":
			String ID = request.getParameter("pagram");
			CompanyModel cm = new CompanyModel();
			cm.setCompany_cd(ID);
			CompanyModel cmNew = getCompanyModel(cm);
			result = cmNew.getCompany_name();
			
			break;

		default:
			break;
		}
		
		return result;
	}
	
	
	public CompanyModel getCompanyModel(CompanyModel cm)
	{
		CompanySelectDao companySelectDao = new CompanySelectDao(cm);
		try {
			List<CompanyModel> lst  = companySelectDao.excute();
			if(lst.size()>0)
			{
				return lst.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
