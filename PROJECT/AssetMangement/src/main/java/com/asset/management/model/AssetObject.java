package com.asset.management.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class AssetObject {
	
	private String id;
	private String RFID;
	private String Name;
	private String Model;
	private String Series;
	private String Department;
	private String Accountant_CD;
	private String DateStart;
	private String  Price;
	private String Note;
	
	public AssetObject(HttpServletRequest request) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		this.Name = request.getParameter("asset_name");
		this.RFID = request.getParameter("asset_rfid");
		this.Accountant_CD = request.getParameter("asset_accountant");
		this.Model = request.getParameter("asset_model");
		this.Series = request.getParameter("asset_series");
		this.Department = request.getParameter("asset_department");
		this.DateStart = request.getParameter("asset_date");
		this.Note = request.getParameter("asset_note");
		this.Price = request.getParameter("asset_price");
	}
	
	
	
	public String getRFID() {
		return RFID;
	}
	public void setRFID(String rFID) {
		RFID = rFID;
	}
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getSeries() {
		return Series;
	}
	public void setSeries(String series) {
		Series = series;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getAccountant_CD() {
		return Accountant_CD;
	}
	public void setAccountant_CD(String accountant_CD) {
		Accountant_CD = accountant_CD;
	}
	public String getDateStart() {
		return DateStart;
	}
	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public AssetObject(String rFID, String name, String model, String series, String department, String accountant_CD,
			String dateStart, String price, String note) {
		super();
		RFID = rFID;
		Name = name;
		Model = model;
		Series = series;
		Department = department;
		Accountant_CD = accountant_CD;
		DateStart = dateStart;
		Price = price;
		Note = note;
	}
	public AssetObject() {
		super();
	}
	
	
	
	

}
