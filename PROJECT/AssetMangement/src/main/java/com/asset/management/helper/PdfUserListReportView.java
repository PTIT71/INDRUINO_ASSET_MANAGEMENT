package com.asset.management.helper;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.asset.management.model.*;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfUserListReportView extends AbstractPdfView {

 @Override
 protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
  response.setHeader("Content-Disposition", "attachment; filename=\"user_list.pdf\"");
  
  @SuppressWarnings("unchecked")
  List<User> list = (List<User>) model.get("userList");
  
  Table table = new Table(4);
  table.addCell("ID");
  table.addCell("USERNAME");
  table.addCell("FIRST NAME");
  table.addCell("LAST NAME");
  
  for(User user : list){
   table.addCell(String.valueOf(user.getId()));
   table.addCell(user.getUsername());
   table.addCell(user.getFirstname());
   table.addCell(user.getLastname());
  }
  
  document.add(table);
 }

}