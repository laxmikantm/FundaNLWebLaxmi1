package com.seleniumtests.dataobject;

import org.testng.annotations.DataProvider;

import com.seleniumtests.support.Helper;


public class LandingPageData {

	private String searchKeyword;
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}



	@DataProvider(name = "searchData")
	public static Object[][] getLoginData() {
		LandingPageData landingPageData = new LandingPageData();
		landingPageData.setSearchKeyword(Helper.SEARCH_KEYWORD);


		return new LandingPageData[][] { { landingPageData } };
	}
	//
	//	@DataProvider(name = "loginData")
	//	public static Object[][] getLoginData() {
	//		return new Object[][] { { Helper.USER_NAME, Helper.PASSWORD } };
	//	}




}
