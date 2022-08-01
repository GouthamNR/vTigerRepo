package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationNameAccountsAndActionPage {
	public OrganizationNameAccountsAndActionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text") private WebElement SearchBoxTextFied;
	@FindBy(name = "search") private WebElement SearchButton;
	@FindAll(@FindBy(xpath = "//table[@style='background-color: rgb(204, 204, 204);']//td//a")) private WebElement OrganizationNanes;
	
	public WebElement getSearchBoxTextFied() {
		return SearchBoxTextFied;
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	public WebElement getOrganizationNanes() {
		return OrganizationNanes;
	}
	
	public void getOrganization(String Organization) {
		if (getOrganizationNanes().getText().contains(Organization)) {
			getOrganizationNanes().click();;
		}
	}
	

}
