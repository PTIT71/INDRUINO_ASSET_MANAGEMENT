package com.asset.management.model;

public class BorrowAssetModel {
	private String Loan_cmpn_cd;
	private String Loan_dept;
	private String Load_Date;
	private String Asset_rfid;
	private String Borrow_cmpn_cd;
	private String Borrow_dept;
	private String Pay_date;
	private String Borrow_reason;
	private String Asset_model;
	private String Loan_cmpn_name;
	private String Borrow_cmpn_name;
	private String Status;
	private String id;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getLoan_cmpn_name() {
		return Loan_cmpn_name;
	}
	public void setLoan_cmpn_name(String loan_cmpn_name) {
		Loan_cmpn_name = loan_cmpn_name;
	}
	public String getBorrow_cmpn_name() {
		return Borrow_cmpn_name;
	}
	public void setBorrow_cmpn_name(String borrow_cmpn_name) {
		Borrow_cmpn_name = borrow_cmpn_name;
	}

	
	
	
	
	
	
	
	
	
	
	public String getLoan_cmpn_cd() {
		return Loan_cmpn_cd;
	}
	public void setLoan_cmpn_cd(String loan_cmpn_cd) {
		Loan_cmpn_cd = loan_cmpn_cd;
	}
	public String getLoan_dept() {
		return Loan_dept;
	}
	public void setLoan_dept(String loan_dept) {
		Loan_dept = loan_dept;
	}
	public String getLoad_Date() {
		return Load_Date;
	}
	public void setLoad_Date(String load_Date) {
		Load_Date = load_Date;
	}
	public String getAsset_rfid() {
		return Asset_rfid;
	}
	public void setAsset_rfid(String asset_rfid) {
		Asset_rfid = asset_rfid;
	}
	public String getBorrow_cmpn_cd() {
		return Borrow_cmpn_cd;
	}
	public void setBorrow_cmpn_cd(String borrow_cmpn_cd) {
		Borrow_cmpn_cd = borrow_cmpn_cd;
	}
	public String getBorrow_dept() {
		return Borrow_dept;
	}
	public void setBorrow_dept(String borrow_dept) {
		Borrow_dept = borrow_dept;
	}
	public String getPay_date() {
		return Pay_date;
	}
	public void setPay_date(String pay_date) {
		Pay_date = pay_date;
	}
	public String getBorrow_reason() {
		return Borrow_reason;
	}
	public void setBorrow_reason(String borrow_reason) {
		Borrow_reason = borrow_reason;
	}
	
	public String getAsset_model() {
		return Asset_model;
	}
	public void setAsset_model(String asset_model) {
		Asset_model = asset_model;
	}
	public String getAsset_series() {
		return Asset_series;
	}
	public void setAsset_series(String asset_series) {
		Asset_series = asset_series;
	}
	public String getAsset_name() {
		return Asset_name;
	}
	public void setAsset_name(String asset_name) {
		Asset_name = asset_name;
	}
	private String Asset_series;
	private String Asset_name;
	
}
