package com.Demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsJob {
	WebDriver driver;
	@BeforeMethod
	public void onStart() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void verify_page_title() {
		Assert.assertTrue(driver.getTitle().contains("Google"), "Test FAIL");
		Reporter.log("Test PASS", true);
	}
	
	@Test
	public void verify_Page_url() {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://"), "Test FAIL");
		Reporter.log("Test PASS", true);
	}
	
	@Test
	public void verify_Search_functionality() {
		Assert.assertTrue(false, "Test FAIL");
		Reporter.log("Test PASS", true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
