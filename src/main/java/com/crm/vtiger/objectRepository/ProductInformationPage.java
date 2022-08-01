package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement ProductCreationMsg;

	public WebElement getProductCreationMsg() {
		return ProductCreationMsg;
	}
	
	public void getProductVerification(String acctualMsg) {
		if (getProductCreationMsg().getText().contains(acctualMsg)) {
			System.out.println("product is Created");
		}
		else {
			System.out.println("Fail: Product Is Not Created");
		}
	}

}
