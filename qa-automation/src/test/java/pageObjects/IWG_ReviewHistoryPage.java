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
public class IWG_ReviewHistoryPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWG_ReviewHistoryPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By approvedRad = By.xpath("//label[contains(text(), 'Approved')]"); 
	private By revisionNeededRad = By.xpath("//label[contains(text(), 'Revision Needed')]"); 
	private By rejectedRad = By.xpath("//label[contains(text(), 'Rejected')]"); 
	private By managerReviewRad = By.xpath("//label[contains(text(), 'Manager Review')]"); 
	private By otherRad = By.xpath("//label[contains(text(), 'Other')]");
	private By contentReviewUpdatedAlr = By.xpath("//div[contains(text(), 'Content Review updated')]");
	private By currentStatusLbl = By.xpath("//div[@class='col-12'][5]");
	private By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
	private By nextBtn =  By.partialLinkText("Next");
	private By backToQueueBtn = By.partialLinkText("Back");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getSaveBtn() {
		return getElement(saveBtn);
	}

	public WebElement getNextBtn() {
		return getElement(nextBtn);
	}

	public WebElement getBackToDocumentsQueueBtn() {
		return getElement(backToQueueBtn);
	}

	public WebElement getApprovedRad() {
		return getElement(approvedRad);
	}

	public WebElement getRevisionNeededRad() {
		return getElement(revisionNeededRad);
	}

	public WebElement getRejectedRad() {
		return getElement(rejectedRad);
	}

	public WebElement getManagerReviewRad() {
		return getElement(managerReviewRad);
	}

	public WebElement getOtherRad() {
		return getElement(otherRad);
	}

	public WebElement getContentReviewUpdatedAlr() {
		return getElement(contentReviewUpdatedAlr);
	}

	public WebElement getCurrentStatusLbl() {
		return getElement(currentStatusLbl);
	}
		
	// methods
	public IWG_ReviewHistoryPage selectVerdict(String verdict) {
		
		waitUntilElementIsDisplayed(getApprovedRad());
		
		switch(verdict.toLowerCase()) {
			case "other": getOtherRad();
				break;
			case "approved": getApprovedRad().click();
				break;
			case "revision needed": getRevisionNeededRad().click();
				break;
			case "rejected": getRejectedRad().click();
				break;
			case "manager review": getManagerReviewRad().click();
				break;
		}
		
		return getInstance(IWG_ReviewHistoryPage.class);
	}
	
	public IWG_ReviewHistoryPage clickSave() {
		
		doStartTimer("Click save button");
		doScrollToElement(getSaveBtn());
		getSaveBtn().click();
		getContentReviewUpdatedAlr();
		doStopTimer();

		return getInstance(IWG_ReviewHistoryPage.class);
	
	}
}
