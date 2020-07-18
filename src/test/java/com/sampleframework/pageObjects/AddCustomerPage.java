package com.sampleframework.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	WebDriver ldriver;
	WebElement listItem;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='#']/span[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;

	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[4]/ul/li/a/span[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;

	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement btnAddnew;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement rdMaleGender;

	@FindBy(xpath = "//input[@id='Gender_Female']")
	WebElement rdFemaleGender;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;

	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement txtTaxExempt;

	@FindBy(xpath = "//div[10]//div[2]//div[1]//div[1]//div[1]")
	WebElement lstcustomerRoles;

	@FindBy(xpath = "//li[@class='k-button']//span[@class='k-select']")
	WebElement clrCustomerroles;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement lstAdministrators;

	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	WebElement lstForumModerators;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement lstGuests;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement lstRegistered;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement lstVendors;

	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement drpVendor;

	@FindBy(xpath = "//input[@id='Active']")
	WebElement chkActive;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtcomments;

	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement capturemsg;

	public void customersMenu() {
		lnkCustomers_menu.click();
	}

	public void customersMenuItem() {
		lnkCustomers_menuitem.click();
	}

	public void clickAddnew() {
		btnAddnew.click();
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String passwd) {
		txtPassword.sendKeys(passwd);
	}

	public void setFirstname(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setGender(String gender) {

		if (gender.equals("Male")) {
			rdMaleGender.click();
		} else if (gender.equals("Female")) {
			rdFemaleGender.click();
		}
	}

	public void setDob(String date) {
		txtDob.sendKeys(date);
	}

	public void setCompanyname(String company) {
		txtCompanyName.sendKeys(company);
	}

	public void setTaxExempt(boolean option) {
		if (option == true) {
			txtTaxExempt.click();
		}
	}

	public void clearCustomerroles() {
		clrCustomerroles.click();
	}

	public void selectCustomerroles(String role) {
		lstcustomerRoles.click();

		switch (role) {
		case "Administrators":
			listItem = lstAdministrators;
			break;
		case "Forum Moderators":
			listItem = lstForumModerators;
			break;
		case "Guests":
			listItem = lstGuests;
			break;
		case "Registered":
			listItem = lstRegistered;
			break;
		case "Vendors":
			listItem = lstVendors;
			break;
			
				}

		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listItem);
	}

	public void setVendor(String vendor) {
		Select select = new Select(drpVendor);
		select.selectByVisibleText(vendor);
	}

	public void setActive(boolean activechkbox) {
		if (activechkbox == true) {
			chkActive.click();
		}
	}

	public void setComments(String comment) {
		txtcomments.sendKeys(comment);
	}

	public void clickSave() {
		btnSave.click();
	}
	
	public String getMsg() {
		return capturemsg.getText();
	}
}
