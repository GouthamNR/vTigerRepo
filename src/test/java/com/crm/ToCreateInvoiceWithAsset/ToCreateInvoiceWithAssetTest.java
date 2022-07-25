package com.crm.ToCreateInvoiceWithAsset;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
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

public class ToCreateInvoiceWithAssetTest{
public static void main(String[] args) throws Throwable {
	//to read the data from properties file.
	FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
	Properties properties = new Properties();
	properties.load(fis);
	String Vurl = properties.getProperty("url");
	String userName = properties.getProperty("userName");
	String password = properties.getProperty("password");
	
	//to read the data from the excel file.
	FileInputStream fisExcel = new FileInputStream("./src/test/resources/VTigerTestData.xlsx");
	Workbook workBook = WorkbookFactory.create(fisExcel);
	Sheet sheet = workBook.getSheet("Asset");
	Row row = sheet.getRow(2);
	Cell cell = row.getCell(0);
	String AssetNo = cell.getStringCellValue();
	Row row1 = sheet.getRow(2);
	Cell cell1 = row1.getCell(1);
	String SerialNumber  = cell1.getStringCellValue();
	Row row2 = sheet.getRow(2);
	Cell cell2 = row2.getCell(2);
	String AssetName  = cell2.getStringCellValue();
	Row row3 = sheet.getRow(2);
	Cell cell3 = row3.getCell(3);
	String ShippingMethod   = cell3.getStringCellValue();
	
	// to set driver executable path.
	WebDriverManager.chromedriver().setup();
	
	//to instantiate the browser specific class.
	WebDriver driver=new ChromeDriver();
	
	//to maximize browser.
	driver.manage().window().maximize();
	
	// to give implicit wait to web elements.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//to pass url to browser.
	driver.get(Vurl);
	
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
	Actions action = new Actions(driver);
	action.moveToElement(more).perform();
	
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
	for (String wId : allwindows) {
		
		//to switch to windows.
		driver.switchTo().window(wId);
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
		
		//to switch to the Invoice&action window.
		if (url.contains("Invoice&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select invoice particular invoice from Invoice&action window.
	String invoiceName = "invoice1";
	driver.findElement(By.linkText(invoiceName)).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows1 = driver.getWindowHandles();
	
	//to access	individual window.
	for (String wId : allwindows1) {
		
		//to switch to windows
		driver.switchTo().window(wId);
		
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
		
		//to switch to the Assets&action window.
		if (url.contains("Assets&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to click on customer name lookup image.
	driver.findElement(By.xpath("//input[@id='account']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows2 = driver.getWindowHandles();
	//to access	individual window.
	for (String wId : allwindows2) {
		
		//to switch to windows
		driver.switchTo().window(wId);
		
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
		
		//to switch to the Accounts&action window.
		if (url.contains("Accounts&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select customer name from Accounts&action window.
	String customerName = "dddd";
	driver.findElement(By.linkText(customerName)).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows3 = driver.getWindowHandles();
	
	//to access	individual window.
	for (String wId : allwindows3) {
		//to switch to windows
		driver.switchTo().window(wId);
		
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
	
		//to switch to the Assets&action window.
		if (url.contains("Assets&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to click on product name loockup image. 
	driver.findElement(By.xpath("//input[@id='product']/..//img[@src='themes/softed/images/select.gif']")).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows4 = driver.getWindowHandles();
	
	//to access	individual window.
	for (String wId : allwindows4) {
		
		//to switch to windows
		driver.switchTo().window(wId);
		
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
		
		//to switch to the Products&action window.
		if (url.contains("Products&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	//to select product from Products&action window.
	String productName = "steel";
	driver.findElement(By.linkText(productName)).click();
	
	//to get all currently active window Id's.
	Set<String> allwindows5 = driver.getWindowHandles();
	
	//to access	individual window.
	for (String wId : allwindows5) {
		
		//to switch to windows
		driver.switchTo().window(wId);
		
		//to get url of window currently under control.
		String url = driver.getCurrentUrl();
		
		//to switch to the Assets&action window.
		if (url.contains("Assets&action")) {
			driver.switchTo().window(wId);
			break;
		}
	}
	
	// to click on calendar lookup image
	driver.findElement(By.xpath("//input[@name='dateinservice']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
	
	//to find all element present in calendar.
	List<WebElement> dates = driver.findElements(By.xpath("//div[@class='calendar']//tbody//tr//td"));
	
	//to access individual element.
	for (WebElement date : dates) {
		
		// to select particular date.
		if (date.getText().contains("27")) {
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
