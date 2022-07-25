package com.crm.CreateEmail;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmailTest {
	public static void main(String[] args) throws Throwable  {
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
		
		//to click on Email link in home page of vTiger application.
		driver.findElement(By.linkText("Email")).click();
		
		//to click on compose link.
		driver.findElement(By.linkText("Compose")).click();
		
		//to get all window ID's currently active.
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			//to switch to the email&action window.
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("Emails&action")) {
				driver.switchTo().window(window);
			}
		}
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to click on select contact icon.
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//to get all window ID's currently active.
		Set<String> newWindows = driver.getWindowHandles();
		for (String window1 : newWindows) {
			//to switch to the contact&action window.
			driver.switchTo().window(window1);
			String url = driver.getCurrentUrl();
			if (url.contains("Contacts&action")) {
				driver.switchTo().window(window1);
				break;
			}
		}
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to select contact from contact&action window.
		String contactName = "ggg gowda";
		driver.findElement(By.linkText(contactName)).click();
		
		//to get all window ID's currently active.q
		Set<String> allwindows = driver.getWindowHandles();
		for (String window2 : allwindows) {
			//to switch back to parent window.
			driver.switchTo().window(window2);
		}
		
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		
		//to enter email address in cc text field.
		driver.findElement(By.name("ccmail")).sendKeys("goutham@gmail.com");
		
		//to enter email address in bcc text field.
		driver.findElement(By.name("bccmail")).sendKeys("goutham@gmail.com");
		
		//to enter subject in subject text field.
		driver.findElement(By.id("subject")).sendKeys("no subject");
		
		//to click on save button.
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//to close the browser.
		driver.quit();
	
	}
	
}

