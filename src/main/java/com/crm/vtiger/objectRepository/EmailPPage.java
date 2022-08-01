package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPPage {
	public EmailPPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Compose']") private WebElement ComposeLink;

	public WebElement getComposeLink() {
		return ComposeLink;
	}
	
	

}
