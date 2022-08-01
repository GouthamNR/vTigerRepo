package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsAndactionPage {
	public ContactsAndactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindAll(@FindBy(xpath = "//table[@style='background-color: rgb(204, 204, 204);']//tbody//td//a")) private WebElement ContactNameForTotextField;
	@FindBy(id = "search_txt") private WebElement SearchBox;
	@FindBy(name = "search") private WebElement SearchButton;
	
	public WebElement getContactNameForTotextField() {
		return ContactNameForTotextField;
	}
	public WebElement getSearchBox() {
		return SearchBox;
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	public void getContact(String ToAddressName) {
		if (getContactNameForTotextField().getText().contains(ToAddressName)) {
			getContactNameForTotextField().click();
		}
	}
	
}
