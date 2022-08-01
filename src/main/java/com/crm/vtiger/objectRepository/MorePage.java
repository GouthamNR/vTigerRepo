package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
	public MorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Sales Order") private WebElement SalesOrderLink;
	@FindBy(name = "Campaigns") private WebElement CampaignsLink;
	@FindBy(name = "Assets") private WebElement AssetsLink;
	@FindBy(name = "Invoice") private WebElement InvoiceLink;
	@FindBy(name = "Vendors") private WebElement VendorsLink;
	
	public WebElement getSalesOrderLink() {
		return SalesOrderLink;
	}
	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	public WebElement getAssetsLink() {
		return AssetsLink;
	}
	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}
	public WebElement getVendorsLink() {
		return VendorsLink;
	}
	
	

}
