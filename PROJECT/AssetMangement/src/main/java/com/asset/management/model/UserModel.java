package com.asset.management.model;

public class UserModel {
	public String name;
	public String employee_cd;
	public String department;
	public String company_cd;
	public String getEmployee_cd() {
		return employee_cd;
	}

	public void setEmployee_cd(String employee_cd) {
		this.employee_cd = employee_cd;
	}

	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public String position;
	public String pasword;
	public String getName() {
		return name;
	}
	
	public  UserModel() {
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployment_CD() {
		return employee_cd;
	}
	public void setEmployment_CD(String usermame) {
		this.employee_cd = usermame;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

}
