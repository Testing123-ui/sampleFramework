package com.sampleframework.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sampleframework.pageObjects.LoginPage;
import com.sampleframework.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	String url = readconfig.getURL();
	String useremail = readconfig.getUserName();
	String userpassword = readconfig.getPassword();
	public static Logger logger;
	public File destFile;
	public LoginPage lpage;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = Logger.getLogger(this.getClass().getName());
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIePath());
			driver = new InternetExplorerDriver();
		}
	}

	@Test(priority = 1)
	public void appLogin() {

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lpage = new LoginPage(driver);
		lpage.setUserName(useremail);
		lpage.setPassword(userpassword);
		lpage.clickLogin();

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	public void captureScreenshot(String testname) {
				
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		destFile = new File("./Screenshots/" + testname + "_" + date + ".png");

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphanumeric(8);
		return generatedString;
	}

}
