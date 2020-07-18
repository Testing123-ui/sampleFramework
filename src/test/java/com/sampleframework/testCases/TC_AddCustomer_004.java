package com.sampleframework.testCases;

import org.testng.annotations.Test;
import com.sampleframework.pageObjects.AddCustomerPage;

public class TC_AddCustomer_004 extends BaseClass {

	@Test(priority=2)
	public void addCustomer() throws InterruptedException {
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.customersMenu();
		addcust.customersMenuItem();
		addcust.clickAddnew();
		
		addcust.setEmail(randomString() + "@gmail.com");
		logger.info("Email Entered");
		
		addcust.setPassword("Test@123");
		logger.info("Password Entered");

		addcust.setFirstname("Testing456");
		logger.info("FirstName Entered");

		addcust.setLastname("Sample");
		logger.info("Lastname Entered");

		addcust.setGender("Female");
		logger.info("Gender Selected");

		addcust.setDob("07/06/2020");
		logger.info("DOB entered");
		addcust.setCompanyname("Test Company");

		addcust.setTaxExempt(false);
		addcust.clearCustomerroles();
		Thread.sleep(2000);

		addcust.selectCustomerroles("Registered");

		addcust.selectCustomerroles("Vendors");
		logger.info("Selected Customer Roles");

		addcust.setVendor("Vendor 1");
		logger.info("Selected Vendor details");
		addcust.setActive(true);

		addcust.setComments("For Testing Purpose");
		logger.info("Comments entered");
		addcust.clickSave();
		logger.info("Customer Saved");
		
		String msg = addcust.getMsg();
		
		if (msg.contains("The new customer has been added successfully.")) {
			logger.info("Customer has been addded Successfully");
		} else {
			logger.info("Failed to register a Customer");
		}
	}

}
