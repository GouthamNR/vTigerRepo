package com.crm.CreateEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.sdet37.GenericUtility.ExcelUtility;
import com.crm.sdet37.GenericUtility.FileUtility;
import com.crm.sdet37.GenericUtility.JavaUtility;
import com.crm.sdet37.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmailTest {
	public static void main(String[] args) throws Throwable  {
		//to read the data from properties file.
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getProperty("url");
		String userName = fLib.getProperty("userName");
		String password = fLib.getProperty("password");	
		int ranNum = jLib.getRandumNum();
		String contactName = eLib.getCellvalue("Contact", 1, 0);
		
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
		
		//to click on Email link in home page of vTiger application.
		driver.findElement(By.linkText("Email")).click();
		
		//to click on compose link.
		driver.findElement(By.linkText("Compose")).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Emails&action=EmailsAjax&file");
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to click on select contact icon.
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Contacts&action");
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select contact from contact&action window.
		
		driver.findElement(By.linkText(contactName)).click();
		
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Emails&action=EmailsAjax&file");
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to enter email address in cc text field.
		driver.findElement(By.name("ccmail")).sendKeys("goutham"+ranNum+"@gmail.com");
		
		//to enter email address in bcc text field.
		driver.findElement(By.name("bccmail")).sendKeys("goutham"+ranNum+"@gmail.com");
		
		//to enter subject in subject text field.
		driver.findElement(By.id("subject")).sendKeys("no subject");
		
		//to click on save button.
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//to close the browser.
		driver.quit();
	
	}
	
}

