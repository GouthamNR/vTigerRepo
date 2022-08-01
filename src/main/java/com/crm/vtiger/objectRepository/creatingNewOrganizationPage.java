package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sdet37.GenericUtility.WebDriverUtility;

public class creatingNewOrganizationPage extends WebDriverUtility{
public creatingNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(name = "accountname") private WebElement OrganizationNameTextField;
@FindBy(name = "industry") private WebElement industryDropDown;
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement saveButton;


public WebElement getOrganizationNameTextField() {
	return OrganizationNameTextField;
}
public WebElement getIndustryDropDown() {
	return industryDropDown;
}
public WebElement getSaveButton() {
	return saveButton;
}

public void createOrganization(WebDriver driver, String organizationName, String industryType) {
	getOrganizationNameTextField().sendKeys(organizationName);
	select(industryDropDown, industryType);
	getSaveButton().click();
	
}
}
