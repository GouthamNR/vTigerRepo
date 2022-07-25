package com.crm.ToCreateInvoiceWithSalesOrder;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateInvoiceWithSalesOrderTest {
public static void main(String[] args) throws Throwable {
	//to read the data from properties file.
	FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
	Properties properties = new Properties();
	properties.load(fis);
	String Vurl = properties.getProperty("url");
	String userName = properties.getProperty("userName");
	String password = properties.getProperty("password");
	
	//to read the data from excel file.
	FileInputStream fisExcel = new FileInputStream("./src/test/resources/VTigerTestData.xlsx");
	Workbook workBook = WorkbookFactory.create(fisExcel);
	Sheet sheet = workBook.getSheet("Invoice");
	Row row = sheet.getRow(2);
	Cell cell = row.getCell(0);
	String subject = cell.getStringCellValue();
	
	//to set driver executable path
	WebDriverManager.chromedriver().setup();
	
	//to instantiate browser specific class.
	WebDriver driver=new ChromeDriver();
	
	//to maximize the browser.
	driver.manage().window().maximize();
	
	//to provide wait to web element.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//to pass url to browser.
	driver.get(Vurl);
	
	//to pass user name to user name text field.
	WebElement usernameTextField = driver.findElement(By.name("user_name"));
	usernameTextField.clear();
	usernameTextField.sendKeys(userName);
	
	//to enter password to password text field.
	WebElement passwordTextField = driver.findElement(By.name("user_password"));
	passwordTextField.clear();
	passwordTextField.sendKeys(password);
	
	//to click on submit button.
	driver.findElement(By.id("submitButton")).submit();
	
	//to click on More link in vTiger Home page.
	WebElement more = driver.findElement(By.xpath("//a[.='More']"));
	Actions action = new Actions(driver);
	action.moveToElement(more).perform();
	
	//to click on invoice link inside More link.
	driver.findElement(By.name("Invoice")).click();
	
	//to click on create invoice lookup image. 
	driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
	
	//to enter subject name in subject text field.
	driver.findElement(By.name("subject")).sendKeys(subject);
	
	//to click on contact lookup image;
	driver.findElement(By.xpath("//input[@name='contact_name']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all window ID's currently active.
	Set<String> allWindowIds = driver.getWindowHandles();
	
	//to access individual window.
	for (String wId : allWindowIds) {
		
		//to switch to windows.
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
		
		//to switch to Contacts&action window.
		if (url.contains("Contacts&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select contact in Contacts&action window.
	String contactName = "ggg gowda";
	driver.findElement(By.linkText(contactName)).click();
	
	//to handle pop-ups.
	driver.switchTo().alert().accept();
	
	//get all window Id's.
	Set<String> allWindowIds1 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds1) {
		
		//to switch to window
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
		
		//to switch to Invoice&action window.
		if (url.contains("Invoice&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to click on organizationName lookup image.
	driver.findElement(By.xpath("//input[@name='account_name']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//get all window Id's.
	Set<String> allWindowIds2 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds2) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
		
		//to switch to Accounts&action window.
		if (url.contains("Accounts&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select organizationName from Accounts&action window.
	String organizationName = "dddd";
	driver.findElement(By.linkText(organizationName)).click();
	
	//to handle pop-ups.
	driver.switchTo().alert().accept();
	
	//get all window Id's.
	Set<String> allWindowIds3 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds3) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
		
		//to switch to Invoice&action window.
		if (url.contains("Invoice&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to click on sales order lookup image.
	driver.findElement(By.xpath("//input[@name='salesorder_name']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//get all window Id's.
	Set<String> allWindowIds4 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds4) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
	
		//to switch to Invoice&action window.
		if (url.contains("SalesOrder&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to click on sales order name in salesOrder&action window.
	String salesOrder = "newSales";
	driver.findElement(By.linkText(salesOrder)).click();
	
	//get all window Id's.
	Set<String> allWindowIds5 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds5) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
	}
	
	//to enter billing address in billing address text area.
	driver.findElement(By.name("bill_street")).sendKeys("abcde");
	
	//to enter shipping address in shipping address text area. 
	driver.findElement(By.name("ship_street")).sendKeys("efghi");
	
	//to click on product lookup image.
	driver.findElement(By.id("searchIcon1")).click();
	
	//get all window Id's.
	Set<String> allWindowIds6 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds6) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
		
		//to get url of window under control.
		String url = driver.getCurrentUrl();
		
		//to switch to Invoice&action window.
		if (url.contains("Products&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select product from product&action window.
	String productName = "steel";
	driver.findElement(By.linkText(productName)).click();
	
	//get all window Id's.
	Set<String> allWindowIds7 = driver.getWindowHandles();
	
	//to access individual windows.
	for (String wId : allWindowIds7) {
		
		//to switch to other windows.
		driver.switchTo().window(wId);
	}
	
	//to enter quantity in quantity text field.
	driver.findElement(By.id("qty1")).sendKeys("12");
	
	//to click on save button.
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//to  verify whether invoice created or not
	WebElement message = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	if (message.getText().contains(subject)) {
		System.out.println("Invoice Created");
	}
	else {
		System.out.println("FAIL: Invoice Not Created");
	}
	driver.quit();
}
}
