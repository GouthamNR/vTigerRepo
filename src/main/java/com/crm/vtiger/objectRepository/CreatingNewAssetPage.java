package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewAssetPage {
	public CreatingNewAssetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "serialnumber") private WebElement SerialNumber;
	@FindBy(xpath = "//input[@id='invoiceid_display']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement InvoiceName;
	@FindBy(xpath = "//input[@id='account_display']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement CustomerName;
	@FindBy(xpath = "//input[@id='product_display']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement 	ProductName;
	@FindBy(xpath = "//input[@name='dateinservice']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement Calendar;
	@FindAll(@FindBy(xpath = "//div[@class='calendar']//tbody//td")) private WebElement dates;
	@FindBy(id = "assetname") private WebElement AssetName;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement SaveButton;
	public WebElement getSerialNumber() {
		return SerialNumber;
	}
	public WebElement getInvoiceName() {
		return InvoiceName;
	}
	public WebElement getCustomerName() {
		return CustomerName;
	}
	public WebElement getProductName() {
		return ProductName;
	}
	public WebElement getCalendar() {
		return Calendar;
	}
	public WebElement getDates() {
		return dates;
	}
	public WebElement getAssetName() {
		return AssetName;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	

}
