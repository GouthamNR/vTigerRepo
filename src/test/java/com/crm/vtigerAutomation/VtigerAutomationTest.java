package com.crm.vtigerAutomation;

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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Goutham N R
 *
 */
public class VtigerAutomationTest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties.txt");
		Properties properties = new Properties();
		properties.load(fis);
		String Vurl = properties.getProperty("url");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		FileInputStream fin = new FileInputStream("./src/test/resources/VTigerTestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Organization");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String  orgName= cell.getStringCellValue();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(Vurl);
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
		Select select = new Select(industryDropDown);
		select.selectByValue("Engineering");
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
		Select select1 = new Select(cotactSelect);
		select1.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("ggg");
		driver.findElement(By.name("lastname")).sendKeys("gowda");
		driver.findElement(By.xpath("//input[@name='account_id']/..//img[@src='themes/softed/images/select.gif']")).click();
		//System.out.println(driver.getCurrentUrl());
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);
		for (String window : allWindowHandles) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			System.out.println(title);
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains("Accounts&action")) {
				driver.switchTo().window(window);
				System.out.println("switched");
			}

		}
	List<WebElement> orgnizationTable = driver.findElements(By.xpath("//table[@style='background-color: rgb(204, 204, 204);']"));
	System.out.println(orgnizationTable);
	for (WebElement webElement : orgnizationTable) {
		//System.out.println(webElement);
		System.out.println(webElement.getText());
		if (webElement.getText().contains(orgName)) {
			/*Actions action = new Actions(driver);
			action.moveToElement(webElement).click(webElement).perform();
			System.out.println(1);*/
			driver.findElement(By.xpath("//a[.='dddd']")).click();
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


