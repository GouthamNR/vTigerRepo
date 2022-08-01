package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
	public SalesOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement CreateSalesOrderLUpImag;

	public WebElement getCreateSalesOrderLUpImag() {
		return CreateSalesOrderLUpImag;
	}
	
	

}
