package com.crm.ToCreateOpportunitiesWithOrganizationAndContacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateOpportunitiesWithOrganizationAndContactsTest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
		Properties properties = new Properties();
		properties.load(fis);
		String Vurl = properties.getProperty("url");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Vurl);
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.clear();
		usernameTextField.sendKeys(userName);
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		String OpportunityName = "TYSS";
		String organizationName = "dddd";
		String campaignName = "campaign1";
		driver.findElement(By.name("potentialname")).sendKeys(OpportunityName);
		driver.findElement(By.xpath("//input[@id='related_to']/..//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("Accounts&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		driver.findElement(By.linkText(organizationName)).click();
		Set<String> allWindow = driver.getWindowHandles();
		for (String window1 : allWindow) {
			driver.switchTo().window(window1);
		}
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@name='campaignid']/..//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			driver.switchTo().window(window);
			String url = driver.getCurrentUrl();
			if (url.contains("Campaigns&action")) {
				driver.switchTo().window(window);
				break;
			}
		}
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText(campaignName)).click();
		Set<String> windowIds = driver.getWindowHandles();
		for (String window : windowIds) {
			driver.switchTo().window(window);
		}
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		WebElement message = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (message.getText().contains(OpportunityName)) {
			System.out.println("opportunity is Created ");
		}
		else {
			System.out.println("FAIL: opportunity is Not Created");
		}
		driver.quit();
	}

}
