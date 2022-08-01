package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sdet37.GenericUtility.WebDriverUtility;

public class creatingNewContactPage extends WebDriverUtility{
	
	public creatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "salutationtype") private WebElement FirstNameType;
	@FindBy(name = "firstname") private WebElement FirstNameTextField;
	@FindBy(name = "lastname") private WebElement LastnameTextField;
	@FindBy(id = "email") private WebElement EmailTextField;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement SaveButton;
	@FindBy(xpath = "//input[@name=\"account_id\"]/..//img[@src=\"themes/softed/images/select.gif\"]") 
	private WebElement OrgLUpImag;
	public WebElement getFirstNameType() {
		return FirstNameType;
	}
	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}
	public WebElement getLastnameTextField() {
		return LastnameTextField;
	}
	public WebElement getEmailTextField() {
		return EmailTextField;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	public WebElement getOrgLUpImag() {
		return OrgLUpImag;
	}
	
	public void createConatact(String visibleText, String firstName, String lastName, String email) {
		select(visibleText, FirstNameType);
		getFirstNameTextField().sendKeys(firstName);
		getLastnameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getSaveButton().click();
		
	}

}
