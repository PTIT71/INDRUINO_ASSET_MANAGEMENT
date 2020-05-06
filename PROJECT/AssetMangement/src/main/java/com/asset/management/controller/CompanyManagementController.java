package com.asset.management.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asset.management.dao.CompanyInsertDao;
import com.asset.management.dao.CompanyLevelSelectDao;
import com.asset.management.dao.CompanySelectDao;
import com.asset.management.form.CompanyForm;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.CompanyLevelModel;
import com.asset.management.model.CompanyModel;
import com.asset.management.model.ExcelFile;

@Controller
public class CompanyManagementController {
	
	@RequestMapping("company-mangement")
	public String init(ModelMap modelMap, HttpServletRequest request) 
	{
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN LÝ CÔNG TY");
		CompanySelectDao companySelectDao = new CompanySelectDao();
		List<CompanyModel> lstCompany = null;
		try {
			lstCompany = companySelectDao.excute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lstCompany.size()>0)
		{
			modelMap.addAttribute("lstCompany", lstCompany);
		}
		
		return "/pages/CompanyManage.jsp";
	}
	
	@RequestMapping("company-insert-init")
	public String CompanyInsert(ModelMap modelMap, HttpServletRequest request) 
	{
		//Truy�?n tên màn hình
		modelMap.addAttribute("TittleScreen","MÀN HÌNH THÊM CÔNG TY QUẢN L�?"); 
		CompanyLevelSelectDao cmpLvl = new CompanyLevelSelectDao();
		List<CompanyLevelModel> lstCompanyLevel = null;
		try {
			lstCompanyLevel = cmpLvl.excute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelMap.addAttribute("lstCompanyLevel", lstCompanyLevel);
		
		return "/pages/CompanyInsert.jsp";
	}
	
	@RequestMapping(value = {"company/{id}"})
	public String ViewCompany(@PathVariable("id") String id, ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{ 
		
		CompanySelectDao companySelect = new CompanySelectDao();
		CompanyForm form = companySelect.excuteById(id);
		modelMap.addAttribute("TittleScreen","MÀN HÌNH XEM THÔNG TIN CÔNG TY"); 
		modelMap.addAttribute("form",form);
		CompanyLevelSelectDao cmpLvl = new CompanyLevelSelectDao();
		List<CompanyLevelModel> lstCompanyLevel = null;
		try {
			lstCompanyLevel = cmpLvl.excute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelMap.addAttribute("lstCompanyLevel", lstCompanyLevel);
		return "/pages/CompanyView.jsp";
		  
	}
	
	
	@RequestMapping("abc")
	public String CompanyInsertS(ModelMap modelMap, HttpServletRequest request) 
	{
		// Get form
				try {
					request.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CompanyForm form = null;
				try {
					form = new CompanyForm(request);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Valitaion form
				String validationName = "";
				//Tên công ty
				if(form.getName()==null || form.getName().length()==0){
					validationName="name";
				}
				//�?ịa chỉ
				if(form.getAddress()==null || form.getAddress().length()==0){
					validationName += "_address";
				}
				//Mã số thuế
				if(form.getTax() == null || form.getTax().length()==0){
					validationName += "_tax";
				}
				//Số điện thoại
				if(form.getPhone() ==null || form.getPhone().length()==0){
					validationName +="_phone";
				}
				//email
				if(form.getEmail()==null || form.getEmail().length()==0){
					validationName="_email";
				}
				//website
				if(form.getWebsite() == null || form.getWebsite().length()==0){
					validationName += "_website";
				}
				//level
				if(form.getLevel()==null || form.getLevel().length()==0){
					validationName += "_level";
				}
				//mô tả
				if(form.getDesciption() ==null || form.getDesciption().length()==0){
					validationName +="_desciption";
				}
				
				/*
				//Validation gặp lỗi
				if(validationName.trim().length()>0)
				{
					
				}
				else
				{
					//Tất cả dữ liệu đ�?u đúng
				}*/
				
				
				
				
				return "/pages/CompanyInsert.jsp";
	}
	@RequestMapping("company-insert-action")
	public String CompanyInsertAction(@RequestParam("file-name") MultipartFile excelFile , ModelMap modelMap, HttpServletRequest request) throws SQLException, UnsupportedEncodingException
	{
		
		//File file = null;
		//file = UploadFileHelper.simpleUpload(excelFile, request, true, "images",request.getSession());
		// Get form
		CompanyForm form = new CompanyForm(request);
		//form.setFile_name(file.getName());
		//Valitaion form
		String validationName = "";
//		//Tên công ty
//		if(form.getName()==null || form.getName().length()==0){
//			validationName="name";
//		}
//		//�?ịa chỉ
//		if(form.getAddress()==null || form.getAddress().length()==0){
//			validationName += "_address";
//		}
//		//Mã số thuế
//		if(form.getTax() == null || form.getTax().length()==0){
//			validationName += "_tax";
//		}
//		//Số điện thoại
//		if(form.getPhone() ==null || form.getPhone().length()==0){
//			validationName +="_phone";
//		}
//		//email
//		if(form.getEmail()==null || form.getEmail().length()==0){
//			validationName="_email";
//		}
//		//website
//		if(form.getWebsite() == null || form.getWebsite().length()==0){
//			validationName += "_website";
//		}
//		//level
//		if(form.getLevel()==null || form.getLevel().length()==0){
//			validationName += "_level";
//		}
//		//mô tả
//		if(form.getDesciption() ==null || form.getDesciption().length()==0){
//			validationName +="_desciption";
//		}
		
		
		//Validation gặp lỗi
		if(validationName.trim().length()>0)
		{
			return "/pages/CompanyInsert.jsp";
		}
		else
		{
			CompanyInsertDao companyInstert  = new CompanyInsertDao(form);
			companyInstert.excute();
			return "redirect:/company-mangement";
		}
	}

}
