package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAndActionPage {
	public ProductsAndActionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text") private WebElement SearchField;
	@FindBy(name = "search") private WebElement SearchButton;
	@FindBy(xpath = "//table[@style='background-color: rgb(204, 204, 204);']//tbody//a") private WebElement Products;
	
	public WebElement getSearchField() {
		return SearchField;
	}
	public WebElement getSearchButton() {
		return SearchButton;
	}
	public WebElement getProducts() {
		return Products;
	}
	
	public void getProductName(String ProductName) {
		if (getProducts().getText().contains(ProductName)) {
			getProducts().click();
		}
	}
	

}
