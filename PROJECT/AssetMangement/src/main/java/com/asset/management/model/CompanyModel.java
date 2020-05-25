package com.asset.management.model;

public class CompanyModel {
	
	private String company_cd;
	private String company_name;
	private String company_address;
	private String company_shortname;
	public String getCompany_file_image() {
		return company_file_image;
	}
	public void setCompany_file_image(String company_file_image) {
		this.company_file_image = company_file_image;
	}
	private String company_delete;
	private String company_file_image;
	
	public String getCompany_delete() {
		return company_delete;
	}
	public void setCompany_delete(String company_delete) {
		this.company_delete = company_delete;
	}
	public CompanyModel() {
		super();
	}
	public CompanyModel(String company_cd, String company_name, String company_address) {
		super();
		this.company_cd = company_cd;
		this.company_name = company_name;
		this.company_address = company_address;
	}
	public String getCompany_cd() {
		return company_cd;
	}
	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_shortname() {
		return company_shortname;
	}
	public void setCompany_shortname(String company_shortname) {
		this.company_shortname = company_shortname;
	}

}
