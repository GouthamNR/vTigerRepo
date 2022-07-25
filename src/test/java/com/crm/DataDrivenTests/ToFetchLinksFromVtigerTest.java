package com.crm.DataDrivenTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToFetchLinksFromVtigerTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
	Properties properties = new Properties();
	properties.load(fis);
	String url = properties.getProperty("url");
	String userName = properties.getProperty("userName");
	String password = properties.getProperty("password");
	FileInputStream fis1 = new FileInputStream("./src/test/resources/vTigerLinks.xlsx");
	Workbook workBook = WorkbookFactory.create(fis1);
	Sheet sheet = workBook.getSheet("data");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	WebElement usernameTextField = driver.findElement(By.name("user_name"));
	usernameTextField.clear();
	usernameTextField.sendKeys(userName);
	WebElement passwordTextField = driver.findElement(By.name("user_password"));
	passwordTextField.clear();
	passwordTextField.sendKeys(password);
	driver.findElement(By.id("submitButton")).submit();
	List<WebElement> links = driver.findElements(By.xpath("//a"));
	for (int i = 0; i < links.size(); i++) {
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		cell.setCellValue(links.get(i).getAttribute("href"));
	}
	FileOutputStream fout = new FileOutputStream("./src/test/resources/vTigerLinks.xlsx");
	workBook.write(fout);
	driver.quit();
}
}
