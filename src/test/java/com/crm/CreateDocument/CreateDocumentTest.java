package com.crm.CreateDocument;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {
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
	//to click on Document link in home page of vTiger application.
	driver.findElement(By.linkText("Documents")).click();
	//to click on create Document icon.
	driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
	//to enter document name in Document name text field.
	String docName = "doc1";
	driver.findElement(By.name("notes_title")).sendKeys(docName);
	//to select a file from computer.
	driver.findElement(By.name("filename")).sendKeys("C:/Users/DELL/Desktop/VtigerAutomation.txt");
	//to click on save button.
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	//verify whether document is created or not.
	WebElement message = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	if (message.getText().contains(docName)) {
		System.out.println("Document is created");
	} else {
		System.out.println("FAIL: Document is Not Created");
	}
	//to close the browser.
	driver.quit();
}
}
