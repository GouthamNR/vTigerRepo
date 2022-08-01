package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInformationPage {
	public contactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement ContactMsg;

	public WebElement getContactMsg() {
		return ContactMsg;
	}
	
	public void getContactVerification(String acctualMsg) {
		if (getContactMsg().getText().contains(acctualMsg)) {
			System.out.println("Contact is Created");
		}
		else {
			System.out.println("FAIL: Contact NOT Created");
		}
	}

}
