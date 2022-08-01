package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailsAndactionPage {
	public EmailsAndactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']") private WebElement ContactLUpImage;
	@FindBy(id = "cc_name") private WebElement CcTextField;
	@FindBy(id = "bcc_name") private WebElement BccTextField;
	@FindBy(id = "subject") private WebElement SubjectTextField;
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]") private WebElement SaveButton;
	
	
	public WebElement getContactLUpImage() {
		return ContactLUpImage;
	}
	public WebElement getCcTextField() {
		return CcTextField;
	}
	public WebElement getBccTextField() {
		return BccTextField;
	}
	public WebElement getSubjectTextField() {
		return SubjectTextField;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	

}
