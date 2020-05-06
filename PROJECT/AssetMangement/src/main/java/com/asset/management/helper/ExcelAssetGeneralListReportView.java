package com.asset.management.helper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.asset.management.model.*;


public class ExcelAssetGeneralListReportView extends AbstractXlsView {

 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
  response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
  
  @SuppressWarnings("unchecked")
  List<AssetObject> list = (List<AssetObject>) model.get("userList");
  
  Sheet sheet = workbook.createSheet("Sheet1");
  
  Row header = sheet.createRow(2);
  header.createCell(0).setCellValue("STT");
  header.createCell(1).setCellValue("RFID");
  header.createCell(2).setCellValue("TÊN MÁY");
  header.createCell(3).setCellValue("MODEL MÁY");
  header.createCell(4).setCellValue("SỐ SERI");
  header.createCell(5).setCellValue("ĐƠN VỊ");
  header.createCell(6).setCellValue("MÃ SỐ KẾ TOÁN");
  header.createCell(7).setCellValue("NGÀY ĐẦU TƯ");
  header.createCell(8).setCellValue("ĐƠN GIÁ");
  header.createCell(9).setCellValue("GHI CHÚ");
  									

  int rowNum = 3;
  int STT=1;
  for(AssetObject user : list){
   Row row = sheet.createRow(rowNum++);
   row.createCell(0).setCellValue(STT++);
   row.createCell(1).setCellValue(user.getRFID());
   row.createCell(2).setCellValue(user.getName());
   row.createCell(3).setCellValue(user.getModel());
   row.createCell(4).setCellValue(user.getSeries());
   row.createCell(5).setCellValue(user.getDepartment());
   row.createCell(6).setCellValue(user.getAccountant_CD());
   row.createCell(7).setCellValue(user.getDateStart());
   row.createCell(8).setCellValue(user.getPrice());
   row.createCell(9).setCellValue(user.getNote());
   
  }
  
 }

}
