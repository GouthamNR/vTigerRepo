package com.crm.CreateDocument;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.sdet37.GenericUtility.FileUtility;
import com.crm.sdet37.GenericUtility.JavaUtility;
import com.crm.sdet37.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {
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
	String docName = "doc"+ranNum;
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
	//to click on Document link in home page of vTiger application.
	driver.findElement(By.linkText("Documents")).click();
	//to click on create Document icon.
	driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
	//to enter document name in Document name text field.
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
