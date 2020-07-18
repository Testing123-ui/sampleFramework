package com.sampleframework.testCases;

import org.testng.annotations.Test;
import com.sampleframework.pageObjects.AddCustomerPage;
import com.sampleframework.pageObjects.SearchCustomerByEmailPage;

public class TC_SearchCustomerByEmail_005 extends BaseClass {

	@Test(priority=2)
	public void searchEmail() {
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.customersMenu();
		addcust.customersMenuItem();
		
		SearchCustomerByEmailPage search = new SearchCustomerByEmailPage(driver);
		search.setEmail("admin@yourStore.com");
		search.clickSearch();

		System.out.println("Table Data is " +search.getTableData());
		
		if (search.getTableData().equals("admin@yourStore.com")) {
			logger.info("Email Id exists");
		}

		else {
			logger.info("Invalid Email");
		}

	}

}
