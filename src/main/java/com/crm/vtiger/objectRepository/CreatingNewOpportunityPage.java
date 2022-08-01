package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {
	public CreatingNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname") private WebElement OpportunityNameTextField;
	@FindBy(xpath = "//input[@id=\\\"related_to_display\\\"]/..//img[@src=\\\"themes/softed/images/select.gif\\\"]")
	private WebElement OrganizationsLUpImg;
	@FindBy(xpath = "//input[@name='campaignid']/..//img[@src='themes/softed/images/select.gif']") 
	private WebElement CampaignLUpImg;
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]") private WebElement SaveButton;
	public WebElement getOpportunityNameTextField() {
		return OpportunityNameTextField;
	}
	public WebElement getOrganizationsLUpImg() {
		return OrganizationsLUpImg;
	}
	public WebElement getCampaignLUpImg() {
		return CampaignLUpImg;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	

}
