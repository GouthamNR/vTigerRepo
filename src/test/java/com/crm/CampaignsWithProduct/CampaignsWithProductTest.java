package com.crm.CampaignsWithProduct;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignsWithProductTest {
	public static void main(String[] args) throws Throwable {
		//to read the data from properties file.
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
		Properties properties = new Properties();
		properties.load(fis);
		String Burl = properties.getProperty("url");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		//to set driver executable path.
		WebDriverManager.chromedriver().setup();
		//to instantiate the chrome driver.
		WebDriver driver = new ChromeDriver();
		//to maximize the window. 
		driver.manage().window().maximize();
		//to provide waiting time to elements.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//to enter the url in search field.
		driver.get(Burl);
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
		Actions action = new Actions(driver);
		action.moveToElement(more).perform();
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
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			//to switch to the product window.
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("Products&action")) {
				driver.switchTo().window(window);
				System.out.println("switched");
				break;
			}
		}
		//to verify driver control.
		System.out.println(driver.getCurrentUrl());
		//to  click on the product link.
		String productName = "steel";
		driver.findElement(By.linkText(productName)).click();
		//to switch back to the parent window.
		Set<String> windows = driver.getWindowHandles();
		for (String oneWindow : windows) {
			driver.switchTo().window(oneWindow);
			String url = driver.getCurrentUrl();
			if (url.contains("Campaigns&action")) {
				driver.switchTo().window(oneWindow);
				break;
			}
		}
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
