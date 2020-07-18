package com.sampleframework.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {

	@Test(priority=2)
	public void login() throws InterruptedException {

		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");

		lpage.clickLogout();
		logger.info("Logged Out");

	}

}
