package com.asset.management.controller;

import javax.servlet.http.HttpServletRequest;

public class UploadImageController {
	public static final String PARAM_BASE_URL = "baseURL";
    
    //get base URL
    public String getBaseURL(HttpServletRequest request){
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
