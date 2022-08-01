package com.crm.CreateSalesOrderWithOpportunities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.sdet37.GenericUtility.ExcelUtility;
import com.crm.sdet37.GenericUtility.FileUtility;
import com.crm.sdet37.GenericUtility.JavaUtility;
import com.crm.sdet37.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSalesOrderWithOpportunitiesTest {
	public static void main(String[] args) throws Throwable {
		//to read the data from properties file.
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getProperty("url");
		String userName = fLib.getProperty("userName");
		String password = fLib.getProperty("password");	
		int ranNum = jLib.getRandumNum();
		String salesOrder = "newSales"+ranNum;
		String contactName = eLib.getCellvalue("salesOrder", 1, 0);
		String OpportunitiesName = eLib.getCellvalue("opportunity", 1, 0);
		String BillingAddress = "newyork";
		String ShippingAddress = "uganda" ;
		String productName = "steel";
		String quantity = "50";
		
		//to set driver executable path.
		WebDriverManager.chromedriver().setup();
		
		//to instantiate the Chrome driver.
		WebDriver driver = new ChromeDriver();
		
		//to maximize the window.
		wLib.maximizeWindow(driver);
		
		//to provide waiting time to elements.
		wLib.waitUntilPageGetsLoad(driver);
		
		//to enter the url in search field.
		driver.get(URL);
		
		//to enter user name in user name text field.
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.clear();
		usernameTextField.sendKeys(userName);
		
		//to enter password in password text field.
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		
		//to click on submit button.
		driver.findElement(By.id("submitButton")).submit();
		
		//to click on More link in home page of vTiger application.
		WebElement more = driver.findElement(By.xpath("//a[.='More']"));
		wLib.mouseOverOnElement(driver, more);
		
		//to click on Sales Order link inside More link.
		driver.findElement(By.name("Sales Order")).click();
		
		//to click on create Create Sales Order icon.
		driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
		
		
		//to enter Sales Order name Sales Order text field.
		driver.findElement(By.name("subject")).sendKeys(salesOrder);
		
		//to click on contacts icon.
		driver.findElement(By.xpath("//input[@name='contact_id']/..//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Contacts&action");
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select contact from contact&action window.
		driver.findElement(By.linkText(contactName)).click();
		
		//to handle popups.
		driver.switchTo().alert().accept();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "SalesOrder&action");
		
		// to click on opportunity icon.
		driver.findElement(By.xpath("//input[@name='potential_name']/..//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Potentials&action");

		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select OpportunitiesName from Potentials&action window.
		driver.findElement(By.linkText(OpportunitiesName)).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "SalesOrder&action");

		//to click on calendar icon.
		driver.findElement(By.xpath("//input[@name='duedate']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
		
		//to get all elements(dates) present in calendar.
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='calendar']//tbody//tr"));
		
		//to access individual element from calendar.
		for (WebElement date : dates) {
			System.out.println(date.getText());
			
			// to select required date from calendar.
			if (date.getText().contains("27")) {
				
				//to click on selected date.
				Actions action = new Actions(driver);
				action.moveToElement(date).click(date).perform();
				break;
			}
		}
		
		//to enter billing address in billing address text field.
		driver.findElement(By.name("bill_street")).sendKeys(BillingAddress);
		
		//to enter Shipping Address in Shipping Address text field.
		driver.findElement(By.name("ship_street")).sendKeys(ShippingAddress);
		
		//to click on select product icon.
		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Products&action");

		//to verify the driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select product from Products&action window.
		driver.findElement(By.linkText(productName)).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "SalesOrder&action");
		
		//to enter the quantity in quantity text field.
		driver.findElement(By.id("qty1")).sendKeys(quantity);
		
		//to click on save button.
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//to verify whether the product is created or not.
		WebElement message = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if (message.getText().contains(salesOrder)) {
			System.out.println("sales order created");
		}
		else {
			System.out.println("FAIL: sales order is not created");
		}
		//to close the browser.
		driver.quit();
	}
}