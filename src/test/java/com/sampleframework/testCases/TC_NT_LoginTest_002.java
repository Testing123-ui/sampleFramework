package com.sampleframework.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NT_LoginTest_002 extends BaseClass {

	@Test(priority=2)
	public void loginNT() throws InterruptedException {

		Assert.assertEquals(driver.getTitle(),"Dashboard / nopCadministration");
		
		lpage.clickLogout();
		logger.info("Logged Out");

	}

}
