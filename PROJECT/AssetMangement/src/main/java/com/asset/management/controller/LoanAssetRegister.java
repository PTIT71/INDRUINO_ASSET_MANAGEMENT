package com.asset.management.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.AssetGeneralSelectDao;
import com.asset.management.dao.BorrowAssetInsertDao;
import com.asset.management.dao.CompanySelectDao;
import com.asset.management.dao.LoanAssetInsertDao;
import com.asset.management.form.AssetGeneralFormSearch;
import com.asset.management.model.AssetObject;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.model.CompanyModel;
import com.asset.management.model.LoanAssetModel;
import com.asset.management.util.Common;
import com.asset.management.util.Constants;
import com.asset.management.util.SessionCommon;
import com.asset.management.util.SystemControl;

@Controller
@RequestMapping("/LoanAssetRegister")
public class LoanAssetRegister {

	String TITLE = "MÀN HÌNH ĐĂNG KÝ CHO MƯỢN TÀI SẢN SẢN";
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		String error = "";
		CompanySelectDao companySelectDao = new CompanySelectDao();
		try {
			List<CompanyModel> lstcmp = companySelectDao.excute();
			if(lstcmp.size()>0)
			{
				mv.addObject(Common.LIST_COMPANY, lstcmp);
			}
			else
			{
				error = error + "Không tìm thấy công ty nào";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error = error + e.toString() + "<br>Lỗi tìm kiếm công ty <br>";
		}
		
		String cmpn_cd = (String) request.getSession().getAttribute(SessionCommon.SESSION_USER_CMPN_CD);
		CompanyModel cm = new CompanyModel();
		cm.setCompany_cd(cmpn_cd);
	    CompanySelectDao cmCompanySelectDao = new CompanySelectDao(cm);
	    try {
			List<CompanyModel> lst = cmCompanySelectDao.excute();
			if(lst.size()>0)
			{
				mv.addObject("loan_cmpn_cd", lst.get(0).getCompany_cd());
				mv.addObject("loan_cmpn_na", lst.get(0).getCompany_name());
			}
		} catch (SQLException e) {
			error = error+"Không tìm thấy công ty mượn tài sản<br>";
		}
		if(error.trim().length()>0)
		{
			mv.addObject(Common.MESSAGE_ERROR, error);
		}
		mv.setViewName("pages/LoanAssetRegister.jsp");
		return mv;
	}
	
	@RequestMapping(params = "save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request) throws UnsupportedEncodingException
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, TITLE);
		
		request.setCharacterEncoding("UTF8");
		
		LoanAssetModel bam = new LoanAssetModel();
		bam.setLoan_cmpn_cd(request.getParameter("loan_cmpn_cd"));
		bam.setLoan_dept(request.getParameter("loan_cmpn_dept"));
		bam.setLoad_Date(request.getParameter("loan_date"));
		bam.setBorrow_cmpn_cd(request.getParameter("borrow_cmpn_cd"));
		bam.setBorrow_dept(request.getParameter("borrow_cmpn_dept"));
		bam.setPay_date(request.getParameter("borrow_date"));
		bam.setBorrow_reason(request.getParameter("borrow_reason"));
		bam.setAsset_rfid(request.getParameter("asset_rfid"));
		bam.setAsset_model(request.getParameter("asset_model"));
		bam.setAsset_name(request.getParameter("asset_name"));
		bam.setAsset_series(request.getParameter("asset_series"));
		
		/*
		 * XÉT 2 TRƯỜNG HỢP
		 * I-MƯỢN TÀI SẢN CÙNG 1 CÔNG TY
		 * II-MƯỢN TÀI SẢN KHÁC CÔNG TY
		 */
		
			AssetGeneralFormSearch form = new AssetGeneralFormSearch();
			form.setRFID(bam.getAsset_rfid());
			form.setModel(bam.getAsset_model());
			form.setDepartment(bam.getLoan_dept());
			form.setSeries(bam.getAsset_series());
			SystemControl systemControl = new SystemControl(request);
			String oldNameCMPN_CD = systemControl.CompanyCDCurrent;
			SystemControl.CompanyCDCurrent = bam.getLoan_cmpn_cd();
			AssetGeneralSelectDao assetGeneralSelectDao = new AssetGeneralSelectDao(form);
			
			try {
				List<AssetObject> lst = assetGeneralSelectDao.excute();
				SystemControl.CompanyCDCurrent = oldNameCMPN_CD;
				if(lst.size()==0)
				{
					mv.addObject(Common.MESSAGE_ERROR, "Không tìm thấy thông tin tài sản");
				}
				else
				{
					if(lst.size() >1)
					{
						mv.addObject(Common.MESSAGE_ERROR, "Tìm thấy nhiều hơn 1 tài sản cùng loại");
					}
					else
					{
						if(lst.size() == 1)
						{
							if(bam.getAsset_rfid()!=null&&bam.getAsset_rfid().trim().length()==0)
							{
								bam.setAsset_rfid(lst.get(0).getRFID());
							}
							LoanAssetInsertDao loanAssetInsertDao = new LoanAssetInsertDao(bam);
							loanAssetInsertDao.excute();
							mv.addObject(Constants.MESSAGE_NOTIFICATION, "ĐĂNG KÝ THÀNH CÔNG");
						}
					}
				}
			} catch (SQLException e) {
				SystemControl.CompanyCDCurrent = oldNameCMPN_CD;
				mv.addObject(Common.MESSAGE_ERROR, "Lỗi trong lúc tìm dữ liệu tài sản");
			}
		
		
		mv.setViewName("pages/LoanAssetRegister.jsp");
		return mv;
	}
	
	@RequestMapping(params = "back", method = RequestMethod.POST)
	public String back()
	{
		return "redirect:/LoanAssetManagement";
	}
}
