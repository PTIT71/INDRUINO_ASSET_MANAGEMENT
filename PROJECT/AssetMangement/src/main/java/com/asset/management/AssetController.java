package com.asset.management;

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

@Controller
public class AssetController {
	
	
	@RequestMapping("/asset")
	public String add(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao();
		modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		return "/pages/asset.jsp";
	}
	
	@RequestMapping("/assetinit")
	public String search(ModelMap modelMap, HttpServletRequest request) throws SQLException 
	{
		AssetGeneralFormSearch form = new AssetGeneralFormSearch(request);
		
		AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao(form);
		modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		return "/pages/asset.jsp";
	}
	
	@RequestMapping(value="importexcel", method = RequestMethod.POST)
	public String importexcel(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request)
	{
		try
		{
			File file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, true, "images");
			System.out.println(file.getPath());
			ExcelHelper eh = new ExcelHelper(file.getAbsolutePath());
			List<AssetObject> lstAssetObject = eh.readData(AssetObject.class.getName(),"vattu",3,1);
			if(lstAssetObject.size() > 0)
			{
				AssetGeneralInsertDao AssetDao = new AssetGeneralInsertDao();
				int number = AssetDao.excuteListData(lstAssetObject);
				System.out.println("So dong anh huong: " + number);
			}
			AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao();
			modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "/pages/asset.jsp";
	}

}
