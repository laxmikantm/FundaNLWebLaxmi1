package com.seleniumtests.dataobject;

import org.testng.annotations.DataProvider;

import com.seleniumtests.support.Helper;


public class HomePageData {


	private String searchKeyword;
	private String distance;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(String maxBudget) {
		this.maxBudget = maxBudget;
	}

	private String maxBudget;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}



	@DataProvider(name = "searchData")
	public static Object[][] getLoginData() {
		HomePageData homePageData = new HomePageData();
		homePageData.setSearchKeyword(Helper.SEARCH_KEYWORD);
		homePageData.setDistance(Helper.DISTANCE);
		homePageData.setMaxBudget(Helper.MAX_BUDGET);
		return new HomePageData[][] { { homePageData } };
	}
}
