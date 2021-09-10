package com.testng.check;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayLaunch {
	WebDriver driver;
	

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void clickAdvanced()  {
		driver.findElement(By.id("gh-as-a")).click();
		Assert.assertEquals(driver.getTitle(), "eBay Search: Advanced Search");
	}
	
	@Test(priority=1)
	public void clickShopCategoryCollectibles() {
		driver.findElement(By.xpath("//a[@class='gh-p'][text()=' Daily Deals']")).click();
		Assert.assertEquals(driver.getTitle(), "Daily Deals on eBay | Best deals and Free Shipping");
	}


	@AfterMethod
	public void tearDown() throws InterruptedException{

		Thread.sleep(3000);
		driver.quit();
	}



}
