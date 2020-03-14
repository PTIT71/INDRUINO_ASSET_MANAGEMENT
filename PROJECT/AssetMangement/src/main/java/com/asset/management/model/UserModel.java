package com.asset.management.model;

public class UserModel {
	public String name;
	public String usermame;
	public String pasword;
	public String getName() {
		return name;
	}
	
	public  UserModel() {
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsermame() {
		return usermame;
	}
	public void setUsermame(String usermame) {
		this.usermame = usermame;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

}
