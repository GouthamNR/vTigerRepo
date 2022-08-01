package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	public DocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement CreateDocumentLUpImg;

	public WebElement getCreateDocumentLUpImg() {
		return CreateDocumentLUpImg;
	}
	
	

}
