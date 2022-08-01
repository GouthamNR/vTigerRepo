package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	public DocumentInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement DocumentCreationMsg;

	public WebElement getDocumentCreationMsg() {
		return DocumentCreationMsg;
	}
	
	public void getDocumentVerification(String acctualMsg) {
		if (getDocumentCreationMsg().getText().contains(acctualMsg)) {
			System.out.println("Document Created");
		}
		else {
			System.out.println("FAIL : Document Not Created");
		}
	}

}
