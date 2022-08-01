package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInformationPage {
	public organizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement orgCreateMsg;

	public WebElement getOrgCreateMsg() {
		return orgCreateMsg;
	}
	
	public void getOrgVerification(WebDriver driver,String acctualMsg) {
		String msg = getOrgCreateMsg().getText();
		if (msg.contains(acctualMsg)) {
			System.out.println("Organization Ceated ");
		}
		else {
			System.out.println("FAIL: Organization NOT Created");
		}
	}

}
