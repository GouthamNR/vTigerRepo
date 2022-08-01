package com.crm.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {
	public CreatingNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "notes_title") private WebElement DucumentTitle;
	@FindBy(xpath = "//td[@id='cke_contents_notecontent']") private WebElement Description;
	@FindBy(name = "filename") private WebElement filename;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement SaveButton;
	public WebElement getDucumentTitle() {
		return DucumentTitle;
	}
	public WebElement getDescription() {
		return Description;
	}
	public WebElement getFilename() {
		return filename;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void createNewDocument(String ducumentTitle, String description,String filePath) {
		getDucumentTitle().sendKeys(ducumentTitle);
		getDescription().sendKeys(description);
		getFilename().sendKeys(filePath);
		getSaveButton().click();
	}
}
