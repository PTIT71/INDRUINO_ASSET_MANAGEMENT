package com.asset.management;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asset.management.helper.ExcelHelper;
import com.asset.management.helper.UploadFileHelper;
import com.asset.management.model.ExcelFile;
import com.asset.management.model.Product;

@Controller
@RequestMapping(value="excel")
public class ExcelImportAssetController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index()
	{
		return "pages/uploadFile.jsp";		
	}
	
	@RequestMapping(value="importexcel", method = RequestMethod.GET)
	public String importexcel(ModelMap modelMap)
	{
		modelMap.put("excelFile", new ExcelFile());
		return "/pages/uploadFile.jsp";
	}
	
	@RequestMapping(value="importexcel", method = RequestMethod.POST)
	public String importexcel(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request)
	{
		try
		{
		File file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, true, "images");
		System.out.println(file.getPath());
		ExcelHelper eh = new ExcelHelper(file.getAbsolutePath());
		modelMap.addAttribute("ten","THINH");
		modelMap.addAttribute("listProducts", eh.readData(Product.class.getName(),"vattu",3,1));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "/pages/display.jsp";
	}

}
