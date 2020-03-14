package com.asset.management.form;

import javax.servlet.http.HttpServletRequest;

public class AssetGeneralFormSearch {
	
	private String RFID;
	public String getRFID() {
		return RFID;
	}
	public void setRFID(String rFID) {
		RFID = rFID;
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
	public String getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}
	public String getPriceStart() {
		return PriceStart;
	}
	public void setPriceStart(String priceStart) {
		PriceStart = priceStart;
	}
	public String getPriceEnd() {
		return PriceEnd;
	}
	public void setPriceEnd(String priceEnd) {
		PriceEnd = priceEnd;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	private String Name;
	private String Model;
	private String Series;
	private String Department;
	private String Accountant_CD;
	private String DateStart;
	private String DateEnd;
	private String  PriceStart;
	private String  PriceEnd;
	private String Note;
	
	public AssetGeneralFormSearch(HttpServletRequest request)
	{
		this.setRFID(request.getParameter("text_rfid"));
		this.setName(request.getParameter("text_asset_name"));
		this.setModel(request.getParameter("text_model"));
		this.setSeries(request.getParameter("text_series"));
		this.setDepartment(request.getParameter("select_department"));
		this.setAccountant_CD(request.getParameter("text_accountant"));
		this.setDateStart(request.getParameter("text_start_date"));
		this.setDateEnd(request.getParameter("text_end_date"));
		this.setPriceEnd(request.getParameter("text_start_price"));
		this.setPriceStart(request.getParameter("text_start_price"));
	}
	
	public AssetGeneralFormSearch()
	{
	
	}

}
