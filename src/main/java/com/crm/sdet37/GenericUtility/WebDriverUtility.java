package com.crm.sdet37.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Goutham
 *
 */
public class WebDriverUtility {
	/**
	 * to maximize the window.
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver) {
driver.manage().window().maximize();
}
/**
 * to minimize the window.
 * @param driver
 */
public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
}
/**
 * to refresh the current window. 
 * @param driver
 */
public void refreshPage(WebDriver driver) {
	driver.navigate().refresh();
}
/**
 * to go back to the previous window.
 * @param driver
 */
public void backToPreviousPage(WebDriver driver) {
	driver.navigate().back();
}
/**
 * to move to the next page.
 * @param driver
 */
public void moveToNextPage(WebDriver driver) {
	driver.navigate().forward();
}
/**
 * to provide implicit wait.
 * @param driver
 */
public void waitUntilPageGetsLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstant.implicitlyWaitDuration));
}
/**
 * to wait until element to be in clickable form. 
 * @param driver
 * @param title
 */
public void waitUntilElementToClick(WebDriver driver, WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * to wait until element to be in visible form.
 * @param driver
 * @param element
 */
public void waitTillElementToVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * to wait until page title got load.
 * @param driver
 * @param title
 */
public void waitTillPageLoadTitle(WebDriver driver, String title) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.until(ExpectedConditions.titleContains(title));
}

/**
 * to wait until page url got load.
 * @param driver
 * @param url
 */
public void waitTillPageLoadUrl(WebDriver driver, String url) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.until(ExpectedConditions.urlContains(url));
}
/**
 * to ignore NoSuchElementException.
 * @param driver
 */
public void ignoreNoSuchElementException(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.ignoring(NoSuchElementException.class);
}
/**
 * to wait until alert message got load.
 * @param driver
 */
public void waitForAlertMsg(WebDriver driver) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IConstant.explicitlyWaitDuration));
	wait.until(ExpectedConditions.alertIsPresent());
}
/**
 * to switch to frame using index.
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver, int index) {
	driver.switchTo().frame(index);
}
/**
 * to switch to frame using ID or Name.
 * @param driver
 * @param name
 */
public void switchToFrame(WebDriver driver, String name) {
	driver.switchTo().frame(name);
}
/**
 * to switch to frame using WebElement.
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver, WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * to switch to main or default Frame.
 * @param driver
 */
public void switchToMainFrame(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * to select elements in dropdown using Index.  
 * @param element
 * @param index
 */
public void select(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
}
/**
 * to select elements in dropdown using value.
 * @param element
 * @param value
 */
public void select(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByValue(value);
}
/**
 * to select elements in dropdown using Visible Text.
 * @param text
 * @param element
 */
public void select(String text,WebElement element) {
	Select select = new Select(element);
	select.selectByVisibleText(text);;
}
/**
 * to get all the options present in DropDown.
 * @param element
 */
public void getAllOptionInDropDown(WebElement element) {
	Select select = new Select(element);
	List<WebElement> options = select.getOptions();
	for (WebElement webElement : options) {
		String text = webElement.getText();
		System.out.println(text);
	}
}
/**
 * to move the mouse courser on the element.
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
}
/**
 * to do Righ Click on the element.
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.contextClick(element).perform();
}
/**
 * to do double click on the element.
 * @param driver
 * @param element
 */
public void doubleClickOnElement(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.doubleClick(element).perform();
}
/**
 * to click on the enter key in the keyboard.
 * @param driver
 */
public void clickOnEnterKey(WebDriver driver) {
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
}
/**
 * to take screenshot 
 * @param driver
 * @param screenShotName
 * @throws IOException
 */
public void takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
	TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
	File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenShot/"+screenShotName+".PNG");
	FileUtils.copyFile(src, dest);
}
/**
 * to give Fluent Wait to the element.
 * @param driver
 */
public void waitAndClickUsingCustomWait(WebDriver driver) {
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	wait.pollingEvery(Duration.ofSeconds(10));
	wait.ignoring(NoSuchElementException.class);
	try {
		wait.wait(10);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
/**
 * to wait and click on the element 
 * @param element
 * @param duration
 * @param sleepTime
 */
public void waitAndClick(WebElement element, int duration, long sleepTime) {
	int count=0;
	while (count<duration) {
		try {
			element.click();
		} catch (Exception e) {
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		count++;
	}
}
/**
 * to switch to the window using title.
 * @param driver
 * @param actualTitle
 */
public void switchToWindowUsingTitle(WebDriver driver,String actualTitle) {
	Set<String> allWndowIds = driver.getWindowHandles();
	for (String windowId : allWndowIds) {
		driver.switchTo().window(windowId);
		String title=driver.getTitle();
		if (title.contains(actualTitle)) {
			break;
		}
	}
}
/**
 * to switch to the window using URL.
 * @param driver
 * @param actualUrl
 */
public void switchToWindowUsingUrl(WebDriver driver, String actualUrl) {
	Set<String> allWindowIDs = driver.getWindowHandles();
	Iterator<String> it = allWindowIDs.iterator();
	while (it.hasNext()) {
		String windowId = (String) it.next();
		driver.switchTo().window(windowId);
		String url = driver.getCurrentUrl();
		if (url.contains(actualUrl)) {
			break;
		}
	}
}
/**
 * to switch to the alert pop_up and accept it.
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertPopUpAndAccept(WebDriver driver, String expectedMsg) {
	Alert alert = driver.switchTo().alert();
	if (alert.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
		System.out.println("PASS: Alert message is Correct");
	}
	else {
		System.out.println("FAIL: Alert message is NOT Correct");
	}
	alert.accept();
}
/**
 * to switch to the alert pop_up and dismiss it.
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertPopUpAndDismiss(WebDriver driver, String expectedMsg) {
	Alert alert = driver.switchTo().alert();
	if (alert.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
		System.out.println("PASS: Alert message is Correct");
	}
	else {
		System.out.println("FAIL: Alert message is NOT Correct");
	}
	alert.dismiss();
}

}

