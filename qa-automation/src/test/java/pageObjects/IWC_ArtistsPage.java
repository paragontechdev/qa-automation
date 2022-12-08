package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWC_ArtistsPage extends BasePage{

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_ArtistsPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By searchArtistsEdt = By.xpath("//input[@placeholder='Search Artists']");
	private By sortLst = By.xpath("//select[@class='ais-SortBy-select']");
	private By recentlyActiveOpt = By.xpath("//option[text()='Recently Active']");
	private By alphabeticalOpt = By.xpath("//option[text()='Alphabetical']");
	private By newestOpt = By.xpath("//option[text()='Newest']");
	private By oldestOpt = By.xpath("//option[text()='Oldest']");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getSearchArtistsEdt() {
		
		return getElement(searchArtistsEdt);
	
	}
	
	public WebElement getSortLst() {
		
		return getElement(sortLst);
	
	}
	
	public WebElement getRecentlyActiveOpt() {
		
		return getElement(recentlyActiveOpt);
	
	}
	
	public WebElement getAlphabeticalOpt() {
		
		return getElement(alphabeticalOpt);
	
	}
	
	public WebElement getNewestOpt() {
	
		return getElement(newestOpt);
	
	}
	
	public WebElement getOldestOpt() {
	
		return getElement(oldestOpt);
	
	}
	
}
