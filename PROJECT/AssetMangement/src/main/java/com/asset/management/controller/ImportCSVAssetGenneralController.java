package com.asset.management.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralInsertDao;
import com.asset.management.dao.DepartmentInsertDao;
import com.asset.management.dao.DepartmentSelectDao;
import com.asset.management.helper.ExcelHelper;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.Department;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.errorExcel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("/ImportCSVAssetGenneral")
public class ImportCSVAssetGenneralController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, "MÀN HÌNH NHẬP DỮ LIỆU TỪ FILE EXCEL");
		mv.setViewName("pages/ImportCSVAssetGenneral.jsp");
		
		return mv;
	}
	
	
	
	@RequestMapping(params="upload", method = RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request) 
	{
		
			File file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, true, "images",request.getSession());
			System.out.println(file.getPath());
			ExcelHelper eh = new ExcelHelper(file.getAbsolutePath());
			ArrayList<errorExcel> lstLineError = new ArrayList<errorExcel>();
			List<AssetObject> lstAssetObject = null;
			try {
				lstAssetObject = eh.readData(AssetObject.class.getName(),"Sheet1",3,1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(lstAssetObject.size() > 0)
			{
				AssetGeneralInsertDao AssetDao = new AssetGeneralInsertDao();
				SystemControl sys = new SystemControl( request);
				String Company_CD = sys.CompanyCDCurrent;
				String id = Common.getDateCurrent("YYYYMMDDHHMMSS");
				Department department = new Department();
				department.setCompany_cd(Company_CD);
				DepartmentSelectDao dmselect = new DepartmentSelectDao(department);
				List<Department> lst = new ArrayList<Department>();
				try {
					lst = dmselect.excute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0;i<lstAssetObject.size();i++)
				{
					try
					{
						lstAssetObject.get(i).setId(id);
						lstAssetObject.get(i).setCompany_CD(Company_CD);
						AssetDao.excuteData(lstAssetObject.get(i));
						boolean NotreGet = false;  
						for(int e = 0;e<lst.size();e++)
						{
							if(lstAssetObject.get(i).getDepartment().trim().equals(lst.get(e).getDept_name().trim()))
							{
								NotreGet= true;
							}
						}
						if(NotreGet==false)
						{
							Department dep = new Department();
							dep.setCompany_cd(Company_CD);
							dep.setDept_cd(Common.getDateCurrent("YYYYmmDDHHMMSS"));
							dep.setDept_name(lstAssetObject.get(i).getDepartment().trim());
							DepartmentInsertDao depin = new DepartmentInsertDao(dep);
							depin.excute();
							lst = dmselect.excute();
						}
						else
						{
							NotreGet=false;
						}
						
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						e.printStackTrace();
						errorExcel er = new errorExcel();
						int line = i+1;
						er.setLine(String.valueOf(line));
						er.setContent(e.toString());
						
						lstLineError.add(er);
					}
				}
				
				
				
				
			}
			
			//AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao();
			//modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		
		
		ModelAndView mv = new ModelAndView();
		if(lstLineError.size() !=0)
		{
			mv.addObject(Common.TITLE_SCREEN, "MÀN HÌNH NHẬP DỮ LIỆU TỪ FILE EXCEL");
			mv.setViewName("pages/ImportCSVAssetGenneral.jsp");
			mv.addObject("lst", lstLineError);
		}
		else
		{
			mv.setViewName("redirect:/AssetManagementGeneral");
		}
		return mv;
	}
	
	@RequestMapping(params="back", method = RequestMethod.POST)
	public String back(HttpServletRequest request) 
	{
		return "redirect:/AssetManagementGeneral";
	}
}
