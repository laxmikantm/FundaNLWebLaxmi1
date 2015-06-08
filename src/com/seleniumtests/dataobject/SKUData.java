/**
 * 
 */
package com.seleniumtests.dataobject;

import org.testng.annotations.DataProvider;

import com.seleniumtests.support.Helper;

/**
 * @author Laxmi.Somni
 *
 */
public class SKUData {
	private String SKUCodePart;
	private String sDescription;
	private int UnitCost;
	private int MaxItems;
	private String sProductTypeValue;
	
	public String getSKUCodePart() {
		return SKUCodePart;
	}
	public void setSKUCodePart(String sKUCodePart) {
		SKUCodePart = sKUCodePart
								+ Helper.getCurrentTimeString();
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	public int getUnitCost() {
		return UnitCost;
	}
	public void setUnitCost(int unitCost) {
		UnitCost = unitCost;
	}
	public int getMaxItems() {
		return MaxItems;
	}
	public void setMaxItems(int maxItems) {
		MaxItems = maxItems;
	}
	public String getsProductTypeValue() {
		return sProductTypeValue;
	}
	public void setsProductTypeValue(String sProductTypeValue) {
		this.sProductTypeValue = sProductTypeValue;
	}

	
	@DataProvider(name = "skuData")
	public static Object[][] getSKUData() {
		SKUData skuData = new SKUData();
		skuData.setSKUCodePart(Helper.SKU_CODE_PART1);
		skuData.setsDescription(Helper.DESCRIPTION);
		skuData.setMaxItems(Helper.MAX_ITEMS);
		skuData.setUnitCost(Helper.UNIT_COST);
	
		return new SKUData[][] { { skuData } };
	}

}
