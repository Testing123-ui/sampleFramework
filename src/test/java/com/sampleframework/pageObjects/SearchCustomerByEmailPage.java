package com.sampleframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmailPage {

	WebDriver ldriver;

	public SearchCustomerByEmailPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement txtEmail;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement btnSearch;
	
	@FindBy(xpath="//td[contains(text(),'admin@yourStore.com')]")
	WebElement tdata;

	public void setEmail(String email) {
		txtEmail.click();
		txtEmail.sendKeys(email);
	}

	public void clickSearch() {
		btnSearch.click();

	}
	
	public String getTableData() {
		String data = tdata.getText();
		return data;
	}

}
