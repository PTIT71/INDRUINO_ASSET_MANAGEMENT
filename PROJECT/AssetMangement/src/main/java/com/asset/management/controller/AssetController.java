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
			modelMap.addAttribute("message","Không tìm thấy dữ liệu yêu cầu<br>Xin thay đổi đi�?u kiện tìm kiếm");
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
	
	@RequestMapping(value="importexcel", method = RequestMethod.POST)
	public String importexcel(@ModelAttribute(value="excelFile") ExcelFile excelFile,  ModelMap modelMap, HttpServletRequest request) 
	{
			String message_error = "";
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
				String Company_CD = (String) request.getSession().getAttribute(Constants.SESSION_USER_CMPN_CD);
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
						int row_error = i+1;
						message_error += row_error +",";
					}
				}
				
				
				
				
			}
			
			//AssetGeneralSelectDao AssetSelectDao = new AssetGeneralSelectDao();
			//modelMap.addAttribute("listAssets",AssetSelectDao.excute() );
		
		modelMap.addAttribute(Common.MESSAGE_ERROR, message_error);
		return "/pages/AssetManagementGeneral.jsp";
	}
}

	