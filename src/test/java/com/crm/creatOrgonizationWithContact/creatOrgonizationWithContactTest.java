package com.crm.creatOrgonizationWithContact;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.sdet37.GenericUtility.ExcelUtility;
import com.crm.sdet37.GenericUtility.FileUtility;
import com.crm.sdet37.GenericUtility.JavaUtility;
import com.crm.sdet37.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Goutham N R
 *
 */
public class creatOrgonizationWithContactTest{
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getProperty("url");
		String userName = fLib.getProperty("userName");
		String password = fLib.getProperty("password");	
		int ranNum = jLib.getRandumNum();
		String orgName = eLib.getCellvalue("Organization", 1, 0)+ranNum;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitUntilPageGetsLoad(driver);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(URL);
		WebElement usernameTextField = driver.findElement(By.name("user_name"));
		usernameTextField.clear();
		usernameTextField.sendKeys(userName);
		WebElement passwordTextField = driver.findElement(By.name("user_password"));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		wLib.select(industryDropDown, "Engineering");
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		String organizationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(organizationName.contains(orgName)) {
			System.out.println("the orgonization is created");
		}
		else {
			System.out.println("the orgonization is not created");
		}
		WebElement contactLink = driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[.='Contacts']"));
		contactLink.click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement cotactSelect = driver.findElement(By.name("salutationtype"));
		wLib.select(cotactSelect, "Mr.");
		String firstName="G"+ranNum;
		String lastName="A"+ranNum;
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_id']/..//img[@src='themes/softed/images/select.gif']")).click();
		
		wLib.switchToWindowUsingUrl(driver, "Accounts&action");
     	List<WebElement> orgnizationTable = driver.findElements(By.xpath("//table[@style='background-color: rgb(204, 204, 204);']"));
	System.out.println(orgnizationTable);
	for (WebElement webElement : orgnizationTable) {
		//System.out.println(webElement);
		//System.out.println(webElement.getText());
		if (webElement.getText().contains(orgName)) {
			driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		}
	}
    Set<String> windowhandles = driver.getWindowHandles();
    for (String onewindow : windowhandles) {
    	driver.switchTo().window(onewindow);
    	System.out.println(driver.getCurrentUrl());
		
	}
    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
    driver.quit();
	}

	}


