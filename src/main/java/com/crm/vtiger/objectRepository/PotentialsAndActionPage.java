package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PotentialsAndActionPage {
	public PotentialsAndActionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text") private WebElement SearchBox;
	@FindBy(name = "search") private WebElement SearchButton;
	@FindAll(@FindBy(xpath = "//table[@style='background-color: rgb(204, 204, 204);']//tbody//td//a"))
	private WebElement Opportunities;
	public WebElement getSearchBox() {
		return SearchBox;
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	public WebElement getOpportunities() {
		return Opportunities;
	}
	
	public void getOpportunitiesName(String opportunityName) {
		if (getOpportunities().getText().contains(opportunityName)) {
			getOpportunities().click();
		}
	}

}
