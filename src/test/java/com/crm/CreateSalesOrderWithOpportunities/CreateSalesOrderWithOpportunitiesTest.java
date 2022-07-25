package com.crm.CreateSalesOrderWithOpportunities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSalesOrderWithOpportunitiesTest {
	public static void main(String[] args) throws Throwable {
		//to read the data from properties file.
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
		Properties properties = new Properties();
		properties.load(fis);
		String Vurl = properties.getProperty("url");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		
		//to set driver executable path.
		WebDriverManager.chromedriver().setup();
		
		//to instantiate the Chrome driver.
		WebDriver driver = new ChromeDriver();
		
		//to maximize the window.
		driver.manage().window().maximize();
		
		//to provide waiting time to elements.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//to enter the url in search field.
		driver.get(Vurl);
		
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
		Actions action = new Actions(driver);
		action.moveToElement(more).perform();
		
		//to click on Sales Order link inside More link.
		driver.findElement(By.name("Sales Order")).click();
		
		//to click on create Create Sales Order icon.
		driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
		
		String salesOrder = "newSales2";
		String contactName = "ggg gowda";
		String OpportunitiesName = "TYSS";
		String BillingAddress = "newyark";
		String ShippingAddress = "uganda" ;
		String productName = "steel";
		String quantity = "50";
		
		//to enter Sales Order name Sales Order text field.
		driver.findElement(By.name("subject")).sendKeys(salesOrder);
		
		//to click on contacts icon.
		driver.findElement(By.xpath("//input[@name='contact_id']/..//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			//to switch to the contact window.
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("Contacts&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select contact from contact&action window.
		driver.findElement(By.linkText(contactName)).click();
		
		//to handle popups.
		driver.switchTo().alert().accept();
		
		//to get all window ID's currently active.
		Set<String> windows1 = driver.getWindowHandles();
		for (String window : windows1) {
			
			//to switch to the SalesOrder&action window.
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("SalesOrder&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		// to click on opportunity icon.
		driver.findElement(By.xpath("//input[@name='potential_name']/..//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		Set<String> windows2 = driver.getWindowHandles();
		for (String window : windows2) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			
			//to switch to the Potentials&action window.
			if (url.contains("Potentials&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select OpportunitiesName from Potentials&action window.
		driver.findElement(By.linkText(OpportunitiesName)).click();
		
		//to get all window ID's currently active.
		Set<String> windows3 = driver.getWindowHandles();
		for (String window : windows3) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			
			//to switch to the SalesOrder&action window.
			if (url.contains("SalesOrder&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
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
		Set<String> windows4 = driver.getWindowHandles();
		//to access individual windows.
		for (String window : windows4) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			
			//to switch to the Products&action window.
			if (url.contains("Products&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		//to verify the driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select product from Products&action window.
		driver.findElement(By.linkText(productName)).click();
		
		//to get all window ID's currently active.
		Set<String> windows5 = driver.getWindowHandles();
		//to access individual windows.
		for (String window : windows5) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			
			//to switch to the SalesOrder&action window.
			if (url.contains("SalesOrder&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		
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