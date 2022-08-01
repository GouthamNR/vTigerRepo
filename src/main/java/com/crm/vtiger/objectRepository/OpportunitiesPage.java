package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Opportunity...']") private WebElement CreateOpportunityLUpImg;

	public WebElement getCreateOpportunityLUpImg() {
		return CreateOpportunityLUpImg;
	}
	
	

}
