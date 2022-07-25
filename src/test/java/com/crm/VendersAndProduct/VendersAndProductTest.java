package com.crm.VendersAndProduct;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VendersAndProductTest {
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
	WebElement more = driver.findElement(By.xpath("//a[.='More']"));
	Actions action = new Actions(driver);
	action.moveToElement(more).perform();
	driver.findElement(By.name("Vendors")).click();
	driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
	String vender = "goutham";
	driver.findElement(By.name("vendorname")).sendKeys(vender);
	driver.findElement(By.xpath("(//input[@title=\'Save [Alt+S]\'])[1]")).click();
	WebElement venderName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	if (venderName.getText().contains(vender)) {
		System.out.println("vender created");
	}
	else {
		System.out.println("Fail: vender not Created");
	}
	driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[.='Products']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	String product = "steel";
	driver.findElement(By.name("productname")).sendKeys(product);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
		driver.switchTo().window(window);
		String url = driver.getCurrentUrl();
		if (url.contains("Vendors&action")) {
			driver.switchTo().window(window);
			System.out.println(1);
			break;
		}
	}
	List<WebElement> table = driver.findElements(By.xpath("//table[@style='background-color: rgb(204, 204, 204);']"));
	for (WebElement webElement : table) {
		System.out.println(webElement.getText());
		if (webElement.getText().contains(vender)) {
			System.out.println(1);
			driver.findElement(By.linkText(vender)).click();
			System.out.println(2);
		}
	}
	Set<String> windows = driver.getWindowHandles();
	for (String oneWindow : windows) {
		driver.switchTo().window(oneWindow);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("Products&action")) {
			driver.switchTo().window(oneWindow);
			break;
		} 
	}
	driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	driver.quit();
	
}
}
