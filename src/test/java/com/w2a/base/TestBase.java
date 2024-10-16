package com.w2a.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.SeleniumHelper;
import com.w2a.utilities.TestUtil;

public class TestBase extends SeleniumHelper{

	/*
	 * WebDriver
	 * Properties
	 * Logs  - log4j jar file in pom.xml, 2 log files(.log) : a) Application log -> adding manual logs; b) Selenium Logs ->autogenerated logs; ,
	 * 		   log4j.properties file -> std file provided by the apache that contains ur log for appender,
	 * 		   Logger class
	 * ExtentReports -->(extentreports) in pom.xml file
	 * DB
	 * Excel --> (poi, poi-ooxml, dom4j, xmlbeans, poi-ooxml-schemas ) dependencies in pom.xm file
	 * Mail
	 * ReportNG --> (reportng, google guice ) dependencies in pom.xml file
	 * Jenkins 
	 * 
	 * 
	 * 
	 */
	
	
	
     
	

	@BeforeSuite()
	public void setUp() throws Exception {
		
		if(driver==null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 try {
				config.load(fis);
				log.debug("Config file got loaded.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 
			 
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				OR.load(fis);
				log.debug("OR file got loaded.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 
			 
			if(config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//executables//gecko.exe");
				driver = new FirefoxDriver();
			} 
			else if(config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver");
				driver = new ChromeDriver();
				log.debug("Chrome launched");
				
			}
			 
			driver.get(config.getProperty("testsuiteUrl"));
			log.debug("Navigated to : "+config.getProperty("testsuiteUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
			Thread.sleep(3000);
			 		 
		}
		
	}
	
	
	
	@AfterSuite()
	public void tearDown() {
		if(driver!=null) {
		   driver.quit();
		}
		log.debug("Test Execution completed.");
	}
	
}
