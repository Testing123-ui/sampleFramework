package com.sampleframework.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sampleframework.pageObjects.LoginPage;
import com.sampleframework.utilities.XLUtils;

public class TC_LoginTestDDT_003 extends BaseClass {

	@Test(dataProvider = "testdata")
	public void loginAppTest(String username, String password) throws InterruptedException {

		driver.get(url);
		logger.info("URL Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		LoginPage lpage = new LoginPage(driver);
		lpage.setUserName(username);
		logger.info("Username Entered");

		lpage.setPassword(password);
		logger.info("Password Entered");

		lpage.clickLogin();
		logger.info("Logged In");

		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");

		lpage.clickLogout();
		logger.info("Logged Out");

	}

	@DataProvider(name = "testdata")
	public String[][] testData() throws IOException {

		String path = "./src/test/java/com/sampleframework/testData/LoginData.xlsx";
		int rows = XLUtils.getRowCount(path, "Sheet1");
		int cols = XLUtils.getCellCount(path, "Sheet1", 1);

		System.out.println("Rows: " + rows);
		System.out.println("Columns: " + cols);

		String data[][] = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return data;
	}

}
