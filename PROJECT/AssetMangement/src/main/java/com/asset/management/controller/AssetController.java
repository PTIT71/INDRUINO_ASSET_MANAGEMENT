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
import com.asset.management.helper.ExcelHelper;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.AssetObject;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.Product;
import com.asset.management.util.Common;

@Controller
public class AssetController {
	
	
	@RequestMapping("/AssetManagementGeneral")
	public String add(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		modelMap.addAttribute("listAssetSearch",AssetSelectDaoSearch.excute() );
		modelMap.addAttribute("formSearch",form);
		return "/pages/AssetManagementGeneral.jsp";
	}
	
	@RequestMapping("/AssetGeneralSearchInit")
	public String search(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		modelMap.addAttribute("TittleScreen","MÀN HÌNH QUẢN LÝ TÀI SẢN CHUNG");
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(null);
		modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		AssetGeneralSelectDao AssetSelectDaoSearch = new AssetGeneralSelectDao(form);
		List<AssetObject> lstAsset = AssetSelectDaoSearch.excute();
		modelMap.addAttribute("listAssetSearch", lstAsset);
		modelMap.addAttribute("formSearch",form);
		if(lstAsset ==null || lstAsset.size()==0)
		{
			modelMap.addAttribute("message","Không tìm thấy dữ liệu yêu cầu<br>Xin thay đổi đi�?u kiện tìm kiếm");
		}
		return "/pages/AssetManagementGeneral.jsp";
	}
	
	@RequestMapping(value="importexcel", method = RequestMethod.POST)
	public String importexcel(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request) 
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
				String id = Common.getDateCurrent("YYYYMMDDHHMMSS");
				for(int i=0;i<lstAssetObject.size();i++)
				{
					try
					{
						lstAssetObject.get(i).setId(id);
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
		
		
		return "/pages/AssetManagementGeneral.jsp";
	}
}

	