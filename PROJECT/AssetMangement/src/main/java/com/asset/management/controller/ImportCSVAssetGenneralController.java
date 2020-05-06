package com.asset.management.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
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
import com.asset.management.helper.ExcelHelper;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;

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
	public String upload(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request) 
	{
		
			File file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, true, "images",request.getSession());
			System.out.println(file.getPath());
			ExcelHelper eh = new ExcelHelper(file.getAbsolutePath());
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
				String Company_CD = (String) request.getSession().getAttribute(Constants.SESSION_USER_CMPN_CD);
				String id = Common.getDateCurrent("YYYYMMDDHHMMSS");
				for(int i=0;i<lstAssetObject.size();i++)
				{
					try
					{
						lstAssetObject.get(i).setId(id);
						lstAssetObject.get(i).setCompany_CD(Company_CD);
						AssetDao.excuteData(lstAssetObject.get(i));
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						e.printStackTrace();
						System.out.println("Lỗi Dòng: " + (i+1));
					}
				}
				
				
				
				
			}
			
			//AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao();
			//modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		
		
		return "redirect:/AssetManagementGeneral";
	}
	
	@RequestMapping(params="back", method = RequestMethod.POST)
	public String back(HttpServletRequest request) 
	{
		return "redirect:/AssetManagementGeneral";
	}
}
