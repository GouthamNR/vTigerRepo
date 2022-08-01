package com.crm.ToCreateInvoiceWithAsset;

import java.util.List;
import java.util.Set;

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

public class ToCreateInvoiceWithAssetTest{
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
	
	//to read the data from the excel file.
	String AssetNo = eLib.getCellvalue("Asset", 2, 0);
	String SerialNumber = eLib.getCellvalue("Asset", 2, 1);
	String AssetName = eLib.getCellvalue("Asset", 2, 2);
	String ShippingMethod = eLib.getCellvalue("Asset", 2, 3);
	String invoiceName = "invoice1";
	String customerName = "dddd";
	
	// to set driver executable path.
	WebDriverManager.chromedriver().setup();
	
	//to instantiate the browser specific class.
	WebDriver driver=new ChromeDriver();
	
	//to maximize browser.
	wLib.maximizeWindow(driver);
	
	// to give implicit wait to web elements.
	wLib.waitUntilPageGetsLoad(driver);
	
	//to pass url to browser.
	driver.get(URL);
	
	//to pass user name to user name text field.
	WebElement usernameTextField = driver.findElement(By.name("user_name"));
	usernameTextField.clear();
	usernameTextField.sendKeys(userName);

	//to pass password to password text field.
	WebElement passwordTextField = driver.findElement(By.name("user_password"));
	passwordTextField.clear();
	passwordTextField.sendKeys(password);
	
	//to click on submit button.
	driver.findElement(By.id("submitButton")).submit();
	
	//to click on More link in Vtiger Home page.
	WebElement more = driver.findElement(By.xpath("//a[.='More']"));
	wLib.mouseOverOnElement(driver, more);

	//to click on asset link in More.
	driver.findElement(By.name("Assets")).click();
	
	//to click on create asset button.
	driver.findElement(By.xpath("//img[@title='Create Asset...']")).click();
	
	//to enter asset number in asset number text field. 
	driver.findElement(By.id("asset_no")).sendKeys(AssetNo);
	
	//to enter serial number in serial number text field
	driver.findElement(By.name("serialnumber")).sendKeys(SerialNumber);
	
	//to click on invoice lookup image.
	driver.findElement(By.xpath("//input[@id='invoiceid']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows = driver.getWindowHandles();
	
	//to access	individual window.
	wLib.switchToWindowUsingUrl(driver, "Invoice&action");

	
	//to select invoice particular invoice from Invoice&action window.
	
	driver.findElement(By.linkText(invoiceName)).click();
	
	//to get all currently active window Id's.
	wLib.switchToWindowUsingUrl(driver, "Assets&action");

	
	//to click on customer name lookup image.
	driver.findElement(By.xpath("//input[@id='account']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all currently active window Id's.
	wLib.switchToWindowUsingUrl(driver, "Accounts&action");

	//to select customer name from Accounts&action window.
	driver.findElement(By.linkText(customerName)).click();
	
	//to get all currently active window Id's.
	wLib.switchToWindowUsingUrl(driver, "Assets&action");
//	Set<String> allwindows3 = driver.getWindowHandles();
//	

	
	//to click on product name loockup image. 
	driver.findElement(By.xpath("//input[@id='product']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all currently active window Id's.
	wLib.switchToWindowUsingUrl(driver, "Products&action");
//	Set<String> allwindows4 = driver.getWindowHandles();

	
	//to select product from Products&action window.
	String productName = "steel";
	driver.findElement(By.linkText(productName)).click();
	
	//to get all currently active window Id's.
	wLib.switchToWindowUsingUrl(driver, "Assets&action");
//	Set<String> allwindows5 = driver.getWindowHandles();

	
	// to click on calendar lookup image
	driver.findElement(By.xpath("//input[@name='dateinservice']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
	
	//to find all element present in calendar.
	List<WebElement> dates = driver.findElements(By.xpath("//div[@class='calendar']//tbody//tr//td"));
	
	//to access individual element.
	for (WebElement date : dates) {
		
		// to select particular date.
		if (date.getText().contains("27")) {
			Actions action = new Actions(driver);
			action=new Actions(driver);
			action.moveToElement(date).click(date).click().perform();
		}
	}
	
	//to enter shipping method in shipping text field.
	driver.findElement(By.name("shippingmethod")).sendKeys(ShippingMethod);
	
	//to enter asset name in asset name text field
	driver.findElement(By.id("assetname")).sendKeys(AssetName);
	
	//to click on save button
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//to verify  whether asset is created or not. 
	WebElement message = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	if (message.getText().contains(AssetName)) {
		System.out.println("asset Created");
	}
	else {
		System.out.println("FAIL: Asset not Createdq");
	}
	driver.quit();
}
}
