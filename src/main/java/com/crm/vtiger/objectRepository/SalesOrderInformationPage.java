package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderInformationPage {
	public SalesOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement SalesOrderCreationMsg;

	public WebElement getSalesOrderCreationMsg() {
		return SalesOrderCreationMsg;
	}
	
	public void getSalesOrderVerificationMsg(String acctualMsg) {
		if (getSalesOrderCreationMsg().getText().contains(acctualMsg)) {
			System.out.println("Sales Order created");
		}
		else {
			System.out.println("FAIL: Sales Order Not Created");
		}
	}

}
