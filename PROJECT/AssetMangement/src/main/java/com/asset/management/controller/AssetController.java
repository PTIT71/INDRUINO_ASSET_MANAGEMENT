package com.asset.management.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralInsertDao;
import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.helper.ExcelAssetGeneralListReportView;
import com.asset.management.helper.ExcelHelper;
import com.asset.management.helper.ExcelUserListReportView;
import com.asset.management.helper.PdfUserListReportView;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.Product;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;
import com.asset.management.util.ViewNameCommon;

@Controller
@RequestMapping("/AssetManagementGeneral")
public class AssetController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		SystemControl systemControl = new SystemControl(request);
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		modelMap.addAttribute("listAssetSearch",AssetSelectDaoSearch.excute() );
		modelMap.addAttribute("formSearch",form);
		return "/pages/AssetManagementGeneral.jsp";
	}
	
	@RequestMapping(params = "search", method = RequestMethod.POST)
	public ModelAndView search(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		ModelAndView mv = new ModelAndView();
		
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		mv.addObject("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		SystemControl systemControl = new SystemControl(request);
		List<AssetObject> lstAsset = AssetSelectDaoSearch.excute();
		mv.addObject("listAssetSearch", lstAsset);
		mv.addObject("formSearch",form);
		if(lstAsset ==null || lstAsset.size()==0)
		{
			modelMap.addAttribute("message","Không tìm thấy dữ liệu yêu cầu<br>Xin thay đổi điều kiện tìm kiếm");
		}
		else
		{
			if(request.getParameter("reportExcel")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new ExcelAssetGeneralListReportView(), "userList", lstAsset);
			}
			if(request.getParameter("reportPDF")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new PdfUserListReportView(), "userList", lstAsset);
			}
		}
		mv.setViewName("pages/AssetManagementGeneral.jsp");
		return mv;
	}
	
	@RequestMapping(params = "reportExcel", method = RequestMethod.POST)
	public ModelAndView excel(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		ModelAndView mv = new ModelAndView();
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		mv.addObject("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		SystemControl systemControl = new SystemControl(request);
		List<AssetObject> lstAsset = AssetSelectDaoSearch.excute();
		mv.addObject("listAssetSearch", lstAsset);
		mv.addObject("formSearch",form);
		if(lstAsset ==null || lstAsset.size()==0)
		{
			modelMap.addAttribute("message","Không tìm thấy dữ liệu yêu cầu<br>Xin thay đổi điều kiện tìm kiếm");
		}
		else
		{
			if(request.getParameter("reportExcel")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new ExcelAssetGeneralListReportView(), "userList", lstAsset);
			}
			if(request.getParameter("reportPDF")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new PdfUserListReportView(), "userList", lstAsset);
			}
		}
		mv.setViewName("pages/AssetManagementGeneral.jsp");
		return mv;
	}
	
	@RequestMapping(params = "reportPDF", method = RequestMethod.POST)
	public ModelAndView PDF(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		ModelAndView mv = new ModelAndView();
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		mv.addObject("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		mv.addObject("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		SystemControl systemControl = new SystemControl(request);
		List<AssetObject> lstAsset = AssetSelectDaoSearch.excute();
		mv.addObject("listAssetSearch", lstAsset);
		mv.addObject("formSearch",form);
		if(lstAsset ==null || lstAsset.size()==0)
		{
			modelMap.addAttribute("message","Không tìm thấy dữ liệu yêu cầu<br>Xin thay đổi điều kiện tìm kiếm");
		}
		else
		{
			if(request.getParameter("reportExcel")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new ExcelAssetGeneralListReportView(), "userList", lstAsset);
			}
			if(request.getParameter("reportPDF")!=null)
			{
				System.out.println("vô rồi nè");
				return new ModelAndView(new PdfUserListReportView(), "userList", lstAsset);
			}
		}
		mv.setViewName("pages/AssetManagementGeneral.jsp");
		return mv;
	}
	
	@RequestMapping(params = "back", method = RequestMethod.POST)
	public ModelAndView back(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		SystemControl syss = new SystemControl(request);
		mv.setViewName("redirect:/feature?cmpn=" + syss.CompanyCDCurrent);
			
		return mv;
	}
}

	