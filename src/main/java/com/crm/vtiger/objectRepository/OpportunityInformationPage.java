package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	public OpportunityInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement OpportunityCreationMsg;
	public WebElement getOpportunityCreationMsg() {
		return OpportunityCreationMsg;
	}
	
	public void getOpportunityVerification(String acctualMsg) {
		if (getOpportunityCreationMsg().getText().contains(acctualMsg)) {
			System.out.println("Opportunity Created");
		}
		else {
			System.out.println("Fail: Opportunity Not Created");
		}
	}

}
