package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sdet37.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(linkText = "Organizations") private WebElement OrganizationLink;
@FindBy(linkText = "Contacts") private WebElement ContactsLink;
@FindBy(linkText = "Opportunities") private WebElement OpportunitiesLink;
@FindBy(linkText = "Products") private WebElement ProductsLink;
@FindBy(linkText = "Documents") private WebElement DocumentsLink;
@FindBy(linkText = "Email") private WebElement EmailLink;
@FindBy(xpath = "//a[.='More']") private WebElement MoreLink;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement Administrator;
@FindBy(xpath = "//a[.='Sign Out']") private WebElement SignOut;

public WebElement getAdministrator() {
	return Administrator;
}
public WebElement getOrganizationLink() {
	return OrganizationLink;
}
public WebElement getContactsLink() {
	return ContactsLink;
}
public WebElement getOpportunitiesLink() {
	return OpportunitiesLink;
}
public WebElement getProductsLink() {
	return ProductsLink;
}
public WebElement getDocumentsLink() {
	return DocumentsLink;
}
public WebElement getEmailLink() {
	return EmailLink;
}
public WebElement getMoreLink() {
	return MoreLink;
}

public WebElement getSignOut() {
	return SignOut;
}
public void Logout(WebDriver driver) {
	mouseOverOnElement(driver, Administrator);
	getSignOut().click();
}

}
