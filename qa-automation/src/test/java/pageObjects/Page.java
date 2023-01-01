package pageObjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ABSTRACTION: Abstract classes can't be instantiated directly. Page class will be used as a 
 * parent class.  Some common fields and methods used by sub classes will be defined here, but
 * objects will be created in the sub-classes. This is a template for those sub-classes pages. 
 */
public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	public String siteUrl = "https://qa.iwantclips.com/";
	
	// constructor
	public Page(WebDriver driver, WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		
	}
	
	// abstract methods: every class that extends this class must have the following abstract methods
	public abstract String getCurrentPage();
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract String getText(WebElement locator); 
	public abstract String getCurrentMethodName();
	public abstract int getHttpResponseCode(String linkUrl) throws MalformedURLException, IOException;
	public abstract WebElement getElement(By locator);
	
	public abstract void waitUntilElementIsDisplayed(WebElement element);
	public abstract void waitUntilElementIsNotDisplayed(WebElement element);
	public abstract void waitUntilElementIsEnabled(WebElement element);
	public abstract void waitUntilElementIsDisabled(WebElement element);
	public abstract void waitForPageTitle(String title);
	
	public abstract void verifyElementIsDisplayed(WebElement element) throws Exception; 
	public abstract void verifyElementIsNotDisplayed(WebElement element) throws Exception; 
	public abstract void verifyElementIsEnabled(WebElement locator) throws Exception;
	public abstract void verifyElementIsDisabled(WebElement element) throws Exception;
	public abstract void verifyPageIsDisplayed(String webPage) throws Exception;
	
	public abstract void doStartTimer(String description);
	public abstract void doStopTimer();
	public abstract void doScrollToElement(WebElement element);
	public abstract void doHighlightElement(WebElement element) throws InterruptedException;
	public abstract void doClick(WebElement element);
	public abstract void doSendKeys(WebElement element, String text) throws Exception;
	public abstract void doMouseOver(WebElement element);
	public abstract void doSelect(WebElement element, String option); 
	public abstract void doClear(WebElement element); 
	public abstract void doFileUpload(WebElement element, String filepath);
	
	public abstract void getStatusOfCurrentPageLinks(boolean logBrokenLinksOnly) throws MalformedURLException, IOException;
	public abstract void doCreateFile(String filepath);
	public abstract void doLogMessage(String logMessage);
	
	/**
	 *  GENERIC CLASSES & METHODS 
	 */
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		
		try {
			// create object of a particular class, represents constructor
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
		}catch(Exception e){
			e.printStackTrace();
			return null; 
		}
				
	}

	
}