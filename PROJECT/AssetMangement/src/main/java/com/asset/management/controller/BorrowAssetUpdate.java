package com.asset.management.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asset.management.dao.BorrowAssetSelectDao;
import com.asset.management.model.BorrowAssetModel;
import com.asset.management.util.Common;

@Controller
@RequestMapping("/BorrowAssetUpdate")
public class BorrowAssetUpdate {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv  = new ModelAndView();
		mv.addObject(Common.TITLE_SCREEN, "MÀN HÌNH CHỈNH SỬA THÔNG TIN TÀI SẢN MƯỢN");
		String id_borrow = request.getParameter("id");
		if(id_borrow != null && id_borrow.length() >0)
		{
			BorrowAssetModel asset = new BorrowAssetModel();
			asset.setId(id_borrow.trim());
			BorrowAssetSelectDao brsd = new BorrowAssetSelectDao(asset);
			try {
				List<BorrowAssetModel> lst = brsd.excute();
				if(lst.size() == 0)
				{
					mv.addObject(Common.MESSAGE_ERROR,"Không tìm thấy tài sản khớp với mã");
				}
				else
				{
					if(lst.size()>1)
					{
						mv.addObject(Common.MESSAGE_ERROR,"Tìm thấy 2 tài sản tương tự<br>Hãy kiểm tra lại");
					}
					else
					{
						mv.addObject("asset",lst.get(0));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				mv.addObject(Common.MESSAGE_ERROR,"Lỗi trong lúc tìm tài sản");
				e.printStackTrace();
				
			}
		}
		else
		{
			mv.addObject(Common.MESSAGE_ERROR,"Không truyền mã quản lý mượn cho màn hình");
		}
		mv.setViewName("pages/BorrowAssetUpdate.jsp");
		return mv;
	}

}
