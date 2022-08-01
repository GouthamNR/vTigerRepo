package com.crm.CampaignsWithProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.sdet37.GenericUtility.FileUtility;
import com.crm.sdet37.GenericUtility.JavaUtility;
import com.crm.sdet37.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignsWithProductTest {
	public static void main(String[] args) throws Throwable {
		//to read the data from properties file.
		JavaUtility jLib = new JavaUtility();
		//ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getProperty("url");
		String userName = fLib.getProperty("userName");
		String password = fLib.getProperty("password");	
		int ranNum = jLib.getRandumNum();
		String productName = "steel"+ranNum;
		//to set driver executable path.
		WebDriverManager.chromedriver().setup();
		//to instantiate the chrome driver.
		WebDriver driver = new ChromeDriver();
		//to maximize the window. 
		wLib.maximizeWindow(driver);
		//to provide waiting time to elements.
		wLib.waitUntilPageGetsLoad(driver);
		//to enter the url in search field.
		driver.get(URL);
		//to enter user name in username text field.
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

		//to click on campaign link inside More link.
		driver.findElement(By.linkText("Campaigns")).click();
		//to click on create Campaign icon.
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//to enter campaign name in campaign name text field.
		String campaignName = "campaign1";
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		//to select product from product and action window.
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		//to get all window ID's currently active.
		wLib.switchToWindowUsingUrl(driver, "Products&action");

		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		//to  click on the product link.
		
		driver.findElement(By.linkText(productName)).click();
		//to switch back to the parent window.
		wLib.switchToWindowUsingUrl(driver, "Campaigns&action");

		//to click on the save button.
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//to verify product is created or not.
		WebElement message = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (message.getText().contains(campaignName)) {
			System.out.println("camaign created");
		} else {
			System.out.println("FAIL: campaign Not Created");
		}
		//to close the browser.
		driver.quit();
	}

}
