package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.sdet37.GenericUtility.WebDriverUtility;

public class CreatingNewProductPage extends WebDriverUtility {
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname") private WebElement ProductnameTextField;
	@FindBy(xpath = "//input[@name=\'sales_start_date\']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement SalesStartDate;
	@FindAll(@FindBy(xpath = "//div[@class='calendar']//tbody//tr//td")) private WebElement dates;
	@FindBy(xpath = "//input[@name='sales_end_date']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement SalesEndDate;
	@FindBy(name = "productcategory") private WebElement ProductcategoryDropDown;
	@FindBy(xpath = "//img[@src=\'themes/softed/images/select.gif\']") private WebElement VendorNameLUpImag;
	@FindBy(xpath = "//input[@name='start_date']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement SupportStartDate;
	@FindBy(xpath = "//input[@name='expiry_date']/..//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement SupportExpiryDate;
	@FindBy(id = "unit_price") private WebElement UnitPrice;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement SaveButton;
    @FindAll(@FindBy(xpath = "//table[@style='background-color: rgb(204, 204, 204);']//tbody//tr//td//a")) 
    private WebElement VendorsName;
	
	public WebElement getProductnameTextField() {
		return ProductnameTextField;
	}
	public WebElement getSalesStartDate() {
		return SalesStartDate;
	}
	public WebElement getDates() {
		return dates;
	}
	public WebElement getSalesEndDate() {
		return SalesEndDate;
	}
	public WebElement getProductcategoryDropDown() {
		return ProductcategoryDropDown;
	}
	public WebElement getVendorNameLUpImag() {
		return VendorNameLUpImag;
	}
	public WebElement getSupportStartDate() {
		return SupportStartDate;
	}
	public WebElement getSupportExpiryDate() {
		return SupportExpiryDate;
	}
	public WebElement getUnitPrice() {
		return UnitPrice;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	public WebElement getVendorsName() {
		return VendorsName;
	}
	
	public void createNewProduct(WebDriver driver,String ProductName, String ProductType,String startdate,String endDate,String venderPageUrl,String acctualVenderName,String ParentUrl) {
		getProductnameTextField().sendKeys(ProductName);
		getSalesStartDate().click();
		if (getDates().getText().contains(startdate)) {
			getDates().click();
		}
		select(ProductcategoryDropDown, ProductType);
		getSalesEndDate().click();
		if (getDates().getText().contains(endDate)) {
			getDates().click();
		}
		
		getVendorNameLUpImag().click();
		switchToWindowUsingUrl(driver, venderPageUrl);
		String venderName = getVendorsName().getText();
		if (venderName.contains(acctualVenderName)) {
			getVendorsName().click();
		}
		
		switchToWindowUsingUrl(driver, ParentUrl);
		getSaveButton().click();
	}
	
	
	

}
