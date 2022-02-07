package com.raj.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.raj.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstname, String lastname, String postcode) throws InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstname);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastname);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			for (int colNum = 0; colNum < cols; colNum++) {
				
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum) ;
			}
		}
		return data;
	}
	
	
}
