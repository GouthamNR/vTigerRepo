package com.crm.javaSqlConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgyAutomationTest {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://localhost:8084/");
	  WebElement userNameTextField = driver.findElement(By.id("usernmae"));
	  userNameTextField.sendKeys("rmgyantra");
}
}
