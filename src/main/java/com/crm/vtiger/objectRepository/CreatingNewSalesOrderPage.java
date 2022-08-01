package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewSalesOrderPage {
	public CreatingNewSalesOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "subject") private WebElement SubjectTextField;
	@FindBy(xpath = "//input[@name='contact_id']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement ContactNameLUpImg;
	@FindBy(xpath = "//input[@name='potential_id']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement OpportunityName;
	@FindBy(xpath = "//input[@name='duedate']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement CallenderLUpImg;
	@FindAll(@FindBy(xpath = "//div[@class=\"calendar\"]//tbody//td")) private WebElement dates;
	@FindBy(xpath = "//input[@name='account_id']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement OrganizationNameLUpImg;
	@FindBy(name = "bill_street") private WebElement  BillingAddress;
	@FindBy(name = "ship_street") private WebElement  ShippingAddress;
	@FindBy(id = "searchIcon1") private WebElement ProductLUpImg;
	@FindBy(id = "qty1") private WebElement QuantityTextField;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement SaveButton;
	public WebElement getSubjectTextField() {
		return SubjectTextField;
	}
	public WebElement getContactNameLUpImg() {
		return ContactNameLUpImg;
	}
	public WebElement getOpportunityName() {
		return OpportunityName;
	}
	public WebElement getCallenderLUpImg() {
		return CallenderLUpImg;
	}
	public WebElement getDates() {
		return dates;
	}
	public WebElement getOrganizationNameLUpImg() {
		return OrganizationNameLUpImg;
	}
	public WebElement getBillingAddress() {
		return BillingAddress;
	}
	public WebElement getShippingAddress() {
		return ShippingAddress;
	}
	public WebElement getProductLUpImg() {
		return ProductLUpImg;
	}
	public WebElement getQuantityTextField() {
		return QuantityTextField;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	

}
