package com.seleniumtests.dataobject;

import org.testng.annotations.DataProvider;

import com.seleniumtests.support.Helper;

public class LoginData {

	private String username;
	private String password;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		LoginData registrationData = new LoginData();
		registrationData.setUsername( Helper.USER_NAME);
		registrationData.setPassword(Helper.PASSWORD);
	
		return new LoginData[][] { { registrationData } };
	}
//
//	@DataProvider(name = "loginData")
//	public static Object[][] getLoginData() {
//		return new Object[][] { { Helper.USER_NAME, Helper.PASSWORD } };
//	}




}
