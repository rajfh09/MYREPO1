package com.raj.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.raj.base.TestBase;

public class loginAsBankManager extends TestBase {

	@Test
	public void loginAsBankManager () throws InterruptedException {
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))), "Login not successful");
		log.debug("Login Successfully Executed");
		
		
	}
	
	
	
	
}
