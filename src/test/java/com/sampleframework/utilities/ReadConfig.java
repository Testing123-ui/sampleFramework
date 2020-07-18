package com.sampleframework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig(){

		try {
			FileInputStream fis = new FileInputStream("./Configuration/config.properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getURL() {
		String applicationurl = pro.getProperty("url");
		return applicationurl;
	}

	public String getUserName() {
		String uname = pro.getProperty("usermail");
		return uname;
	}

	public String getPassword() {
		String passwd = pro.getProperty("password");
		return passwd;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIePath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
